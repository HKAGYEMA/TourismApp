package eighteen.cmp.nan.itourbradford;

/**
 * Created by Belal on 9/5/2017.
 */

public class Hero {
    private String name;
    private String description;
    private String dob;
    private String dob1;
    private String country;
    private String height;
    private String height1;
    private String height2;
    private String spouse;
    private String children;
    private String image;
    private boolean select = false;

    public Hero(String name, String description, String dob, String dob1, String country,
                String height, String height1, String height2, String spouse, String children, String image) {
        super();
        this.name = name;
        this.description = description;
        this.dob = dob;
        this.dob1 = dob1;
        this.country = country;
        this.height = height;
        this.height1 = height1;
        this.height2 = height2;
        this.spouse = spouse;
        this.children = children;
        this.image = image;
    }

public Hero(){

}



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public String getDob1() {
        return dob1;
    }

    public void setDob1(String dob1) {
        this.dob1 = dob1;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeight1() {
        return height1;
    }

    public void setHeight1(String height1) {
        this.height1 = height1;
    }


    public String getHeight2() {
        return height2;
    }

    public void setHeight2(String height2) {
        this.height2 = height2;
    }


    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSelected(boolean select){
        this.select = select;
    }

    public boolean getSelected(){
        return this.select;
    }

}
