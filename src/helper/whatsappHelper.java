package helper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class whatsappHelper {

    public void sendMessage(String phoneNumber, String status_transaksi, String nama_member, String no_telp, String detail_pesanan) {
        String msg = "";
        if (status_transaksi == "Selesai") {
            msg = "Pesanan anda telah selesai, silahkan diambil di toko kami. Terima kasih telah menggunakan jasa kami.";
        } else if (status_transaksi == "Pengerjaan") {
            msg = "Pesanan anda sedang dalam proses pengerjaan, silahkan menunggu. Terima kasih telah menggunakan jasa kami.";
        } else if (status_transaksi == "Antar") {
            msg = "Pesanan anda sedang dalam proses pengantaran, silahkan menunggu. Terima kasih telah menggunakan jasa kami.";
        } else if (status_transaksi == "Jemput") {
            msg = "Pesanan anda sedang dalam proses pengambilan, silahkan menunggu. Terima kasih telah menggunakan jasa kami.";
        } else {
            msg = "Pesanan anda sedang dalam proses pengerjaan, silahkan menunggu. Terima kasih telah menggunakan jasa kami.";
        }

        String template_message =
                "===== Pemberitahuan =====\n" +
                        "\n" +
                        "PESAN OTOMATIS\n" +
                        "\n" +
                        "Halo kak " + nama_member + ", seluruh " + msg + "\n" +

                        "\n" +
                        "Outlet : Sianjelau\n" +
                        "Nama Pelanggan : " + nama_member + "\n" +
                        "No Handphone :  " + no_telp + "\n" +
                        "\n" +

                        "Detail\n" +
                        "--------------------------------\n" +
                        "" + detail_pesanan + "\n" +
                        "--------------------------------\n";

        String encoded_message = template_message.replace(" ", "%20");
        encoded_message = encoded_message.replace("\n", "%5Cn");

        databaseHelper db = new databaseHelper();
        String api_endpoint = db.getApiEndpointSetting();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(api_endpoint))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .method("POST", HttpRequest.BodyPublishers.ofString("to=" + phoneNumber + "&message=" + encoded_message))
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
