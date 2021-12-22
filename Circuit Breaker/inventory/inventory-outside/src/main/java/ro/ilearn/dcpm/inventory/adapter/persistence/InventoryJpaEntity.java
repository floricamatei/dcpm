package ro.ilearn.dcpm.inventory.adapter.persistence;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class InventoryJpaEntity {

    @Id
    @SequenceGenerator(name = "inventory_seq_generator", sequenceName = "inventory_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_seq_generator")
    private Long id;

    @Version
    private int version;

    @Column(name = "book_id")
    private Long bookId;

    private int quantity;

    public Long getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

}