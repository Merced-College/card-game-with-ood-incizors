public class Card {
    private String suit;
    private String rank;
    private int value;
    private Picture picture;

    // Default constructor
    public Card() {
        this.suit = "";
        this.rank = "";
        this.value = 0;
        this.picture = null;
    }

    // Parameterized constructor
    public Card(String suit, String rank, int value, Picture picture) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.picture = picture;
    }

    // Parameterized constructor for String picture (for compatibility)
    public Card(String suit, String rank, int value, String picturePath) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.picture = new Picture(picturePath);
    }

    // Copy constructor
    public Card(Card other) {
        this.suit = other.suit;
        this.rank = other.rank;
        this.value = other.value;
        this.picture = other.picture;
    }

    // Accessors (getters)
    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public Picture getPicture() {
        return picture;
    }

    // Mutators (setters)
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    // Helper method to capitalize the first letter of a word
    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    // toString method
    @Override
    public String toString() {
        return capitalize(rank) + " of " + capitalize(suit) + " (value: " + value + ", picture: " + (picture != null ? picture.toString() : "none") + ")";
    }
}
