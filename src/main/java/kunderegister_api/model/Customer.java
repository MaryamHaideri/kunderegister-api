package kunderegister_api.model;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Customer {



    private Integer id;

    @NotBlank(message = "Navn kan ikke være tomt")
    private String name;

    @NotBlank(message = "Telefonnummer kan ikke være tomt")
    @Pattern(
            regexp = "[0-9]{8}",
            message = "Telefonnummer må bestå av nøyaktig 8 sifre"
    )
    private String phone;

    @NotBlank(message = "E-postadresse kan ikke være tom")
    @Email(message = "E-postadressen må ha et gyldig format")
    private String email;

    private String note;


    public Customer() {
    }

    public Customer(Integer id, String name, String phone, String email, String note) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.note = note;
    }

    public Integer  getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}