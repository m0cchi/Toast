package frame;

import java.awt.Dimension;
import java.awt.Toolkit;


public class WindowEnvironment {
    private static final String OS_NAME = System.getProperty("os.name").toLowerCase();
    private static final int OS_SUB = OS_NAME.startsWith("mac") ? 20 : 0;
    private static final int SUB = 5;
    protected static final Dimension GLOBAL_WINDOW_DIMENSION = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = WindowEnvironment.GLOBAL_WINDOW_DIMENSION.width / 5;
    public static final int HEIGHT = WindowEnvironment.GLOBAL_WINDOW_DIMENSION.height / 10;
    public static final Location.X LEFT = new Location.X(SUB);
    public static final Location.X RIGHT = new Location.X(GLOBAL_WINDOW_DIMENSION.width - WIDTH - SUB);
    public static final Location.X CROSSWISE_CENTER = new Location.X(GLOBAL_WINDOW_DIMENSION.width/2 - WIDTH/2);
    public static final Location.Y TOP = new Location.Y(SUB + OS_SUB);
    public static final Location.Y BOTTOM = new Location.Y(GLOBAL_WINDOW_DIMENSION.height - HEIGHT - SUB);
    public static final Location.Y LENGTHWISE_CENTER = new Location.Y(GLOBAL_WINDOW_DIMENSION.height/2 - HEIGHT/2);
    // guard
    public interface Value {
        public int get();
    }

    public static class Location {
        public static class X implements Value {
            private int x;

            private X() {
            }

            private X(int x) {
                this.x = x;
            }

            public int get() {
                return x;
            }
        }

        public static class Y implements Value {
            private int y;

            private Y() {
            }

            private Y(int y) {
                this.y = y;
            }

            public int get() {
                return y;
            }
        }

        public class Crosswise {
            private Crosswise() {
            }
        }

        public class Lengthwise {
            private Lengthwise() {
            }
        }
    }
}
