package com.jlgale.springboot.app.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.List;

@Setter
@Getter
@Component
public class Invoice {

    @Autowired
    private Client client;
    @Value("${config.invoice.description}")
    private String description;
    @Autowired
    @Qualifier("listItem2")
    private List<Item> listItems;

    public Integer getTotalInvoice() {
        return listItems.stream()
                .map(i->i.getTotal())
                .reduce(0, (sum, importe) -> sum + importe);
    }

}
