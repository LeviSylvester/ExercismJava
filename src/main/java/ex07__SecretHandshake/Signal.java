package ex07__SecretHandshake;

enum Signal {

    WINK, DOUBLE_BLINK, CLOSE_YOUR_EYES, JUMP;

    static Signal get(int value) {
        switch (value) {
            case 1: return WINK;
            case 10: return DOUBLE_BLINK;
            case 100: return CLOSE_YOUR_EYES;
            case 1000: return JUMP;
            default: return null;
        }
    }

}