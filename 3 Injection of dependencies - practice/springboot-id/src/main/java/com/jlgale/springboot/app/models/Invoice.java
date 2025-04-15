package com.jlgale.springboot.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Setter
@Getter
@Component
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"targetSource", "advisors"})  // ->se usa por que se estaba inyectando un proxy y
                                                       // jackson tenia problemas al mapear algunos atributos

//@SessionScope
@RequestScope
public class Invoice implements Cloneable{


    @Autowired
    private Client client;

    @Value("${config.invoice.description}")
    private String description;

    @Autowired
    @Qualifier("listItem1")
    private List<Item> listItems;

    @PostConstruct
    public void init() {
        System.out.println("Iniciando........");
        client.setLaststname(client.getLaststname().concat(" Pepe"));
        description = description.concat(" del cliente: ").concat(client.getFirstname()+" "+client.getLaststname());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destruyendo el componente invoice");
    }

    public Integer getTotalInvoice() {
        // Manera 1
//        return listItems.stream()
//                .mapToInt(Item::getTotal)
//                .sum();

        // Manera 2
        return listItems.stream()
                .map(i -> i.getTotal())
                .reduce(0, (sum, total) -> sum + total);

        // Manera 3
//                return listItems.stream()
//                .map(Item::getTotal)
//                .reduce(Integer::sum).orElseThrow();


    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Invoice(client, description, listItems);
        }
    }
}
