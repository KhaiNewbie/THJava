package nguyenquangkhai.Lab3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import nguyenquangkhai.Lab3.Validator.annotation.ValidCategoryId;
import nguyenquangkhai.Lab3.Validator.annotation.ValidUserId;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 50, min = 1, message = "Title must be less than 50 character")
    private String title;

    @Column(name = "author")
    @Size(max = 50, min = 1, message = "Author must be less than 50 character")
    private String author;

    @Column(name = "price")
    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ValidCategoryId
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;
}
