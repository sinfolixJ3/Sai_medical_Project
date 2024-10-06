package com.sinfolix.Sai_Samarth.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "image_file")
@Data
public class ImageFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_type", nullable = false)
    private String fileType;

    @Lob  // Indicates that this field should be treated as a large object (BLOB)
    @Column(name = "data", nullable = false, columnDefinition = "LONGBLOB")
    private byte[] data;  // Store the image binary data
}
