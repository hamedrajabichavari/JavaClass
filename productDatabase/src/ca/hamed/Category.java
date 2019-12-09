package ca.hamed;

public class Category {

    private int id;
    private String name;
    private int sub_category_id;

    public Category(int id, String name, int sub_category_id) {
        this.id = id;
        this.name = name;
        this.sub_category_id = sub_category_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(int sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sub_category_id=" + sub_category_id +
                '}';
    }
}