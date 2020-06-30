package Pojo;

public class NewGameConsole {
    private Integer id;
    private String name;
    private String model;
    private Integer price;
    private Integer includeGames;
    private String company;

    public NewGameConsole() {
    }

    public NewGameConsole(Integer id, String name, String model, Integer price, Integer includeGames, String company) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
        this.includeGames = includeGames;
        this.company = company;
    }

    public Integer getId() {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIncludeGames() {
        return includeGames;
    }

    public void setIncludeGames(Integer includeGames) {
        this.includeGames = includeGames;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Console" +
                "id=" + id +
                ", name=" + name +
                ", model='" + model +
                ", price=" + price +
                ", includeGames=" + includeGames +
                ", company=" + company;
    }
}
