package entity;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private Double value;

    @Column
    private String name;

    @Column
    private String symbol;

    public Currency() {
    }

    public Currency(Double value, String name, String symbol) {
        this.value = value;
        this.name = name;
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "cost='" + value + '\'' +
                ", name='" + name + '\'' +
                ", symbol=" + symbol + '\'' +
                '}';
    }
}
