package functions.models;

public class Country {
    private int start;
    private int end;
    private String name;
    private String image;

    public Country(int start, int end, String name, String image) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.image = image;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
