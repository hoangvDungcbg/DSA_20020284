import edu.princeton.cs.algs4.Picture;

 public class SeamCarver {
    private int[][] picture;
    private Picture pic;
    private int[][] color;
    private int[][] old;
    private double[][] energy;
    private int width;
    private int height;

     // create a seam carver object based on the given picture
    public SeamCarver(Picture picture)
    {

        if (picture == null){
            throw new NullPointerException();
        }
        width = picture.width();
        height = picture.height();
        energy = new double[width][height];
        this.picture = new int[width][height];
        old = new int[picture.width()][picture.height()];
        for (int i = 0; i < width(); i++)
        {
            for (int j = 0; j < height(); j++)
                this.picture[i][j] = picture.getRGB(i, j);
        }

        for (int i = 0; i < width(); i++)
        {
            for (int j = 0; j < height(); j++)
                energy[i][j] = computeEnergy(i, j);
        }
    }

     private int[][] getColor(Picture picture) {
         int[][] color = new int[picture.width()][picture.height()];
         for (int i = 0; i < picture.width(); i++)
             for (int j = 0; j < picture.height(); j++) {
                 color[i][j] = picture.getRGB(picture.width() - 1, picture.height() - 1);
             }
         return color;
     }

    private double computeEnergy(int x, int y)
    {
        if (x == 0 || x == width() - 1 || y == 0 || y == height() - 1)
            return 1000.0;

        int rgbUp = picture[x][y - 1];
        int rgbDown = picture[x][y + 1];
        int rgbLeft = picture[x - 1][y];
        int rgbRight = picture[x + 1][y];
        double rx = Math.pow(((rgbLeft >> 16) & 0xFF) - ((rgbRight >> 16) & 0xFF), 2);
        double gx = Math.pow(((rgbLeft >> 8) & 0xFF) - ((rgbRight >> 8) & 0xFF), 2);
        double bx = Math.pow(((rgbLeft >> 0) & 0xFF) - ((rgbRight >> 0) & 0xFF), 2);
        double sumx = rx+gx+bx;
        double ry = Math.pow(((rgbUp >> 16) & 0xFF) - ((rgbDown >> 16) & 0xFF), 2);
        double gy = Math.pow(((rgbUp >> 8) & 0xFF) - ((rgbDown >> 8) & 0xFF), 2);
        double by = Math.pow(((rgbUp >> 0) & 0xFF) - ((rgbDown >> 0) & 0xFF), 2);
        double sumy = ry+gy+by;
        return Math.sqrt(sumx + sumy);
    }

    public Picture picture()
    {
        Picture pic = new Picture(width, height);
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                pic.setRGB(i, j, picture[i][j]);

        return pic;
    }
     // width of current picture
    public int width()
    {
        return width;
    }
     // height of current picture
    public     int height()
    {
        return height;
    }
     // energy of pixel at column x and row y
    public  double energy(int x, int y)
    {
        if (x < 0 || x > width - 1 || y < 0 || y > height - 1)
            throw new IllegalArgumentException();
        return energy[x][y];
    }

    private void relaxedge(int x, int y,double[][] distTo, int[][] edgeTo)
    {
        if (distTo[x][y + 1] > distTo[x][y] + energy[x][y + 1])
        {
            distTo[x][y + 1] = distTo[x][y] + energy[x][y + 1];
            edgeTo[x][y + 1] = x;
        }
        if (x > 0 && distTo[x - 1][y + 1] > distTo[x][y] + energy[x - 1][y + 1])
        {
            distTo[x - 1][y + 1] = distTo[x][y] + energy[x - 1][y + 1];
            edgeTo[x - 1][y + 1] = x;
        }
        if (x < width() - 1 && distTo[x + 1][y + 1] > distTo[x][y] + energy[x + 1][y + 1])
        {
            distTo[x + 1][y + 1] = distTo[x][y] + energy[x + 1][y + 1];
            edgeTo[x + 1][y + 1] = x;
        }
    }

    private void transpose()
    {
        int basket = width;
        width = height;
        height = basket;

        double[][] newenergy = new double[width][height];
        int[][] newpixels = new int[width][height];

        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                newenergy[i][j] = energy[j][i];
                newpixels[i][j] = picture[j][i];
            }
        }

        energy = newenergy;
        picture = newpixels;
    }
     // sequence of indices for horizontal seam
    public int[] findHorizontalSeam()
    {
        transpose();
        int[] hor = findVerticalSeam();
        transpose();
        return hor;
    }
     // sequence of indices for vertical seam
    public int[] findVerticalSeam()
    {
        int[] seam = new int[height];
        double[][] distto = new double[width][height];
        int[][] edgeto = new int[width][height];

        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                if (j == 0) distto[i][j] = energy[i][j];
                else distto[i][j] = Double.MAX_VALUE;
            }
        }
        for (int j = 0; j < height - 1; j++)
        {
            for (int i = 0; i < width; i++)
            {
                relaxedge(i,j,distto, edgeto);
            }
        }

        double min = Double.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < width; i++)
        {
            if (distto[i][height - 1] < min)
            {
                min = distto[i][height - 1];
                minIndex = i;
            }
        }

        seam[height - 1] = minIndex;
        for (int j = height - 2; j >= 0; j--)
        {
            seam[j] = edgeto[seam[j + 1]][j + 1];
        }

        return seam;
    }
     // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam)
    {
        if (height <= 1 || seam == null || seam.length != width){
            throw new IllegalArgumentException();
        }
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < width; i++)
        {
            if (seam[i] > max) {
                max = seam[i];
            }
            if (seam[i] < min) {
                min = seam[i];
            }

            for (int j = seam[i]; j < height - 1; j++)
            {
                picture[i][j] = picture[i][j + 1];
            }
        }

        height--;
        if (min > 0) {
            min--;
        }
        if (max > height - 1) {
            max = height - 1;
        }

        for (int i = 0; i < width; i++)
        {
            for (int j = min; j <= max; j++)
                energy[i][j] = computeEnergy(i, j);
            for (int j = max + 1; j < height - 1; j++)
                energy[i][j] = energy[i][j + 1];
        }

    }
     // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam)
    {
        transpose();
        removeHorizontalSeam(seam);
        transpose();
    }

     //  unit testing (optional)
     public static void main(String[] args) {
     }
}