package de.gtopcu.maps.extended;

public class TriggerMapSettings {
    private final boolean onGet;
    private final boolean onBeforePut;
    private final boolean onAfterPut;

    private TriggerMapSettings(boolean onGet, boolean onBeforePut, boolean onAfterPut) {
        this.onGet = onGet;
        this.onBeforePut = onBeforePut;
        this.onAfterPut = onAfterPut;
    }

    public boolean isOnGet() {
        return onGet;
    }

    public boolean isOnBeforePut() {
        return onBeforePut;
    }

    public boolean isOnAfterPut() {
        return onAfterPut;
    }

    public static class Builder {
        private boolean onGet = false;
        private boolean onBeforePut = false;
        private boolean onAfterPut = false;

        public Builder onGet(boolean onGet) {
            this.onGet = onGet;
            return this;
        }

        public Builder onBeforePut(boolean onBeforePut) {
            this.onBeforePut = onBeforePut;
            return this;
        }

        public Builder onAfterPut(boolean onAfterPut) {
            this.onAfterPut = onAfterPut;
            return this;
        }

        public TriggerMapSettings build() {
            return new TriggerMapSettings(this.onGet, this.onBeforePut, this.onAfterPut);
        }
    }
}
