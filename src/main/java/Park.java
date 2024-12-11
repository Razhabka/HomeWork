public class Park {
    private String name; // Названия парка аттракционов
    private String address; // Адрес парка
    private String parkWorkTime; // Время работы

    FerrisWheel ferrisWheel;
    ShootingGallery shootingGallery;

    public Park(String name, String address, String parkWorkTime) {
        this.name = name;
        this.address = address;
        this.parkWorkTime = parkWorkTime;
        ferrisWheel = new FerrisWheel();
        shootingGallery = new ShootingGallery();
    }


    public class FerrisWheel {
        private String ferrisWheelWorkTime;
        private String ferrisWheelDescription;
        private String ferrisWheelPrice;


        public String getFerrisWheelWorkTime() {
            return ferrisWheelWorkTime;
        }

        public String getFerrisWheelDescription() {
            return ferrisWheelDescription;
        }

        public String getFerrisWheelPrice() {
            return ferrisWheelPrice;
        }

        public void setFerrisWheelWorkTime(String ferrisWheelWorkTime) {
            this.ferrisWheelWorkTime = ferrisWheelWorkTime;
        }

        public void setFerrisWheelDescription(String ferrisWheelDescription) {
            this.ferrisWheelDescription = ferrisWheelDescription;
        }

        public void setFerrisWheelPrice(String ferrisWheelPrice) {
            this.ferrisWheelPrice = ferrisWheelPrice;
        }
    }

    public class ShootingGallery {
        private String shootingGalleryWorkTime;// Время работы аттракциона
        private String shootingGalleryDescription; // Описание аттракциона
        private String shootingGalleryPrice; // Цена аттракциона

        public String getShootingGalleryWorkTime() {
            return shootingGalleryWorkTime;
        }

        public String getShootingGalleryDescription() {
            return shootingGalleryDescription;
        }

        public String getShootingGalleryPrice() {
            return shootingGalleryPrice;
        }

        public void setShootingGalleryWorkTime(String shootingGalleryWorkTime) {
            this.shootingGalleryWorkTime = shootingGalleryWorkTime;
        }

        public void setShootingGalleryDescription(String shootingGalleryDescription) {
            this.shootingGalleryDescription = shootingGalleryDescription;
        }

        public void setShootingGalleryPrice(String shootingGalleryPrice) {
            this.shootingGalleryPrice = shootingGalleryPrice;
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getParkWorkTime() {
        return parkWorkTime;
    }
}
