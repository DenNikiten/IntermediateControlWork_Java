import java.util.Objects;

public class Toy implements Comparable<Toy> {

    private int id;
    private String title;
    private int frequencyDropoutToy;

    public Toy(int id, String title, int frequencyDropoutToy) {
        this.id = id;
        this.title = title;
        this.frequencyDropoutToy = frequencyDropoutToy;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getFrequencyDropoutToy() {
        return frequencyDropoutToy;
    }

    public void setFrequencyDropoutToy(int frequencyDropoutToy) {
        this.frequencyDropoutToy = frequencyDropoutToy;
    }

    public String getInfo() {
        return String.format("id %d: %s", id, title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return title.equals(toy.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.frequencyDropoutToy, o.frequencyDropoutToy);
    }
}