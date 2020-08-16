int growingPlant(int upSpeed, int downSpeed, int desiredHeight) {
    int height = 0;

    for (int i = 0; i < 9999; i++) {
        height += upSpeed;

        if (height >= desiredHeight) {
            return i + 1;
        }

        height -= downSpeed;
    }

    return -1;
}
