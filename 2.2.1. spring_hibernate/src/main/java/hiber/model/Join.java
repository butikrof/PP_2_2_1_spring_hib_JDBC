package hiber.model;

import javax.persistence.Column;

public class Join {

    private int Id;
    private int carId;
    private int userId;
    private String model;
    private String series;
    private String firstName;
    private String lastName;
    private String email;

    public Join(int carId, int userId, String model, String series, String firstName, String lastName, String email) {
        this.Id = Id;
        this.carId = carId;
        this.userId = userId;
        this.model = model;
        this.series = series;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Join() {

    }

    public int getId() {
        return Id;
    }

    public int getCarId() {
        return carId;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Join{" +
                "Id=" + Id +
                "carId=" + carId +
                ", userId=" + userId +
                ", model='" + model + '\'' +
                ", series='" + series + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
