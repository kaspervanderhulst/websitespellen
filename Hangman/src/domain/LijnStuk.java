package domain;

        import javafx.scene.layout.Pane;
        import javafx.scene.shape.Line;

public class LijnStuk extends Vorm implements Drawable{
    private Punt startPunt, eindPunt;

    public LijnStuk(Punt startPunt, Punt eindPunt) {
        setStartEnEindPunt(startPunt, eindPunt);
    }

    public void setStartEnEindPunt(Punt startPunt, Punt eindPunt) {
        if (startPunt == null || eindPunt == null || startPunt.equals(eindPunt))
            throw new DomainException();
        this.startPunt = startPunt;
        this.eindPunt = eindPunt;
    }

    public Punt getStartPunt() {
        return startPunt;
    }

    public Punt getEindPunt() {
        return eindPunt;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LijnStuk))
            return false;
        return (startPunt.equals(((LijnStuk) obj).startPunt) && eindPunt.equals(((LijnStuk) obj).eindPunt)) || (startPunt.equals(((LijnStuk) obj).eindPunt) && eindPunt.equals(((LijnStuk) obj).startPunt));
    }

    @Override
    public Omhullende getOmhullende() {
        int minX = startPunt.getX();
        int maxX = startPunt.getX();
        int minY = startPunt.getY();
        int maxY = startPunt.getY();
        if (eindPunt.getX() < minX)
            minX = eindPunt.getX();
        if (eindPunt.getX() > maxX)
            maxX = eindPunt.getX();
        if (eindPunt.getY()< minY)
            minY = eindPunt.getY();
        if (eindPunt.getY() > maxY)
            maxY = eindPunt.getY();
        return new Omhullende(new Punt(minX, minY), maxX - minX, maxY - minY);
    }

    @Override
    public void teken(Pane root) {
        Line line = new Line(this.getStartPunt().getX(), this.getStartPunt().getY(), this.getEindPunt().getX(), this.getEindPunt().getY());
        line.setStrokeWidth(5);
        root.getChildren().addAll(line);
    }
}
