package uiMain;

public interface AsciiArt {

     static void banner(String championshipName, String year) {
        String[] banner = {
                "  _    _             /'_'_/.-''/",
                "  \\`../ |o_..__     / /__   / /  -=" + championshipName + "=-   _\\=.o.=/_",
                ".,(_)______(_).>  / ___/  / /                             |_|_____|_|",
                "~~~~~~~~~~~~~~~~~~/_/~~~~~/_/~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~jrei~~"
        };

        // Imprime el nombre del campeonato centrado
        int bannerWidth = banner[0].length();
        int nameLength = championshipName.length();
        int padding = (bannerWidth - nameLength) / 2;
        String centeredName = " ".repeat(padding) + championshipName + " ".repeat(padding);

        banner[2] = banner[2].replace(championshipName, centeredName);

        // Reemplaza "WORLD CHAMPIONSHIP" con el año
        banner[1] = banner[1].replace("WORLD CHAMPIONSHIP", year);

        // Imprime el banner completo
        for (String line : banner) {
            System.out.println(line);
        }
    }

    public static void car() {
        String art = "                         __\n" +
                "                   _.--\"\"  |\n" +
                "    .----.     _.-'   |\\/| |--.\n" +
                "    |jrei|__.-'   _________|  |_)  _______________  \n" +
                "    |  .-\"\"-.\"\"\"\" ___,    `----'\"))   __   .-\"\"-.\"\"\"--._  \n" +
                "    '-' ,--. `    |tic|   .---.       |:.| ' ,--. `      _`.\n" +
                "     ( (    ) ) __|tac|__ \\\\|// _..--  \\/ ( (    ) )--._\".-.\n" +
                "      . `--' ;\\__________________..--------. `--' ;--------'\n" +
                "       `-..-'                               `-..-'";

        System.out.println(art);
    }
    public static void bienvenida() {
        String art = "       .-----------,-.-----.\n" +
                "       |:_______ //(_)\\____|:\n" +
                "    ___||=======// ,--.\\===.|  ___                 ¡Bienvenido al Proyecto de la Fédération\n" +
                "  .'.\"\"'\\____.'/ | (__)\\__|\\.'.\"\"'.\n" +
                "  | |\"\"\"||._       '---'__   `-|\"\"\"|                   Internationale de l'Automobile!\n" +
                "  | |\"\"\"||. '-.___  ` -'--'     `-.| ___\n" +
                "  | |\"\"\"|| '-.'.\"\"'.----._     .---:'.\"\"\"'.\n" +
                "  `.'_\".'|   | |\"\"\"|_____ `. /\\ \\___||_\"\"\"|                < Pulsa para continuar > \n" +
                "          '-.| |\"\"_/_____\\  \\ \\\\ \\_____\\_|		                 \n" +
                "             | |\"|____    ', '__/   ____|\n" +
                "             `.'__.'  `'---'-'---'-'.'__.'";

        System.out.println(art);
    }
    public static void raceFlag() {
        String pattern = "00000       00000       000000      000000      000000       000000      000000\n" +
                "00000       00000       000000      000000      000000       000000      000000\n" +
                "00000       00000       000000      000000      000000       000000      000000\n" +
                "      000000      000000      000000      000000       000000      000000     \n" +
                "      000000      000000      000000      000000       000000      000000     \n" +
                "      000000      000000      000000      000000       000000      000000     \n" +
                "00000       00000       000000      000000      000000       000000      000000\n" +
                "00000       00000       000000      000000      000000       000000      000000\n" +
                "00000       00000       000000      000000      000000       000000      000000\n" +
                "      000000      000000      000000      000000       000000      000000     \n" +
                "      000000      000000      000000      000000       000000      000000     \n" +
                "      000000      000000      000000      000000       000000      000000     ";

        System.out.println(pattern);
    }
}
