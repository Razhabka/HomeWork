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
        private String ferrisWheelWorkTime = "10:00AM - 6:00PM";
        private String ferrisWheelPrice = "10$";


        public String getFerrisWheelWorkTime() {
            return ferrisWheelWorkTime;
        }


        public String getFerrisWheelPrice() {
            return ferrisWheelPrice;
        }

        public void setFerrisWheelWorkTime(String ferrisWheelWorkTime) {
            this.ferrisWheelWorkTime = ferrisWheelWorkTime;
        }


        public void setFerrisWheelPrice(String ferrisWheelPrice) {
            this.ferrisWheelPrice = ferrisWheelPrice;
        }
    }

    public class ShootingGallery {
        private String shootingGalleryWorkTime = "10:00AM - 6:00PM";// Время работы аттракциона

        private String shootingGalleryPrice = "5$"; // Цена аттракциона

        public String getShootingGalleryWorkTime() {
            return shootingGalleryWorkTime;
        }

        public String getShootingGalleryPrice() {
            return shootingGalleryPrice;
        }

        public void setShootingGalleryWorkTime(String shootingGalleryWorkTime) {
            this.shootingGalleryWorkTime = shootingGalleryWorkTime;
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
