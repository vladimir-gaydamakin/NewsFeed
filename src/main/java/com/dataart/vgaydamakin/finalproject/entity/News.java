package com.dataart.vgaydamakin.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor  // для сериализации, проверить нужен ли...
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String header;
    private String content;

    public News(String header, String content) {
        this.header = header;
        this.content = content;
    }
}
