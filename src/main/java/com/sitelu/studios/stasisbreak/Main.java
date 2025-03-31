package com.sitelu.studios.stasisbreak;

import java.util.Map;

public class Main {

        public static void main(String[] args) {

                Scene sceneEndingSelfish = new Scene(
                                "Selfish Ending",
                                "Kamu meluncur sendirian dengan Escape Pod, meninggalkan Avalon dan seluruh penumpangnya. \n"
                                                +
                                                "Jauh di belakangmu, lampu-lampu kapal perlahan meredup. \n" +
                                                "Kamu selamat, tapi menanggung kesunyian yang kelak menghantuimu",
                                "Ending");

                sceneEndingSelfish.setChoices(
                                "A", false,
                                "Tidak ada lanjutan",
                                null, 0, 0,
                                "Permainan berakhir di sini. Terima kasih telah bermain",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                Scene sceneEndingMutual = new Scene(
                                "Mutual Ending",
                                "Bersama Aurora, kamu berhasil **menstabilkan reaktor**. Penumpang tetap tertidur aman, perjalanan Avalon berlanjut. \nKalian saling menatap bintang-bintang dengan harapan baru",
                                "Ending");

                sceneEndingMutual.setChoices(
                                "A", false,
                                "Tamat",
                                null, 0, 0,
                                "Cerita berakhir dengan harapan, terima kasih",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                Scene sceneEndingDeath = new Scene(
                                "Death Ending",
                                "Kesalahan fatal. **Reaktor meledak**, Avalon hancur sepenuhnya, menewaskan semua yang berada di dalamnya. \nKegelapan luar angkasa menelan sisa-sisa kapal",
                                "Ending");

                sceneEndingDeath.setChoices(
                                "A", false,
                                "Tamat",
                                null, 0, 0,
                                "Tidak ada lagi harapan. Semuanya berakhir",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                Scene sceneEndingHeroic = new Scene(
                                "Heroic Ending",
                                "kamu mengorbankan dirimu di ruang reaktor, menahan radiasi mematikan sambil mengaktifkan protokol perbaikan penuh. \nAvalon perlahan kembali stabil, sedangkan waktumu kian singkat. Namamu akan dikenang selamanya di antara bintang",
                                "Ending");

                Scene scenePCB = new Scene(
                                "Passenger Cryosleep Bay",
                                "Ruangan cryo utama bagi penumpang Avalon",
                                "Room");

                scenePCB.setScene(
                                true,
                                "Passenger Cryosleep Bay (Revisited)",
                                "Kamu kembali ke ruangan cryo penumpang, tidak ada hal baru di sini",
                                "Room");

                Scene sceneL1 = new Scene(
                                "Hallway L1",
                                "Lorong utama yang menghubungkan ruangan-ruangan penting di kapal",
                                "Hallway");

                sceneL1.setScene(
                                true,
                                "Hallway L1 (Revisited)",
                                "Kamu kembali ke lorong utama. Meskipun sudah pernah melewatinya, suasana tetap terasa tegang",
                                "Hallway");

                Scene sceneAdmin = new Scene(
                                "Admin",
                                "Ruang admin berisi arsip misi, log aktivitas kru",
                                "Room");

                sceneAdmin.setScene(
                                true,
                                "Admin (Revisited)",
                                "Kamu kembali ke Admin, suasana tak banyak berubah",
                                "Room");

                Scene sceneCargoBay = new Scene(
                                "Cargo Bay",
                                "Ruangan luas penuh kontainer dan perlengkapan kargo",
                                "Room");

                sceneCargoBay.setScene(
                                true,
                                "Cargo Bay (Revisited)",
                                "Kamu kembali ke Cargo Bay, tampak sedikit berantakan",
                                "Room");

                Scene sceneCrewCryo = new Scene(
                                "Crew Cryosleep Bay",
                                "Ruang cryo khusus awak kapal. Banyak pod berlabel",
                                "Room");

                sceneCrewCryo.setScene(
                                true,
                                "Crew Cryosleep Bay (Revisited)",
                                "Kamu kembali ke cryo kru, mungkin Aurora sudah bangun",
                                "Room");

                Scene sceneCockpit = new Scene(
                                "Cockpit",
                                "Ruang kendali utama Avalon, layar dan panel elektronik",
                                "Room");

                sceneCockpit.setScene(
                                true,
                                "Cockpit (Revisited)",
                                "Kamu kembali ke ruang kendali, panel masih berkedip",
                                "Room");

                Scene sceneL2 = new Scene(
                                "Hallway L2",
                                "Lorong penghubung menuju Maintenance, Medbay, Engine/Electrical",
                                "Hallway");

                sceneL2.setScene(
                                true,
                                "Hallway L2 (Revisited)",
                                "Kamu kembali ke Hallway L2, suasana tidak banyak berubah",
                                "Hallway");

                Scene sceneMaintenance = new Scene(
                                "Maintenance Section",
                                "Ruang perbaikan untuk panel listrik dan sistem pendukung Avalon",
                                "Room");

                sceneMaintenance.setScene(
                                true,
                                "Maintenance Section (Revisited)",
                                "Kamu kembali ke ruang perbaikan, sebagian panel mungkin telah diperbaiki",
                                "Room");

                Scene sceneMedbay = new Scene(
                                "Medbay",
                                "Ruang medis otomatis, di mana sistem penyembuhan darurat masih aktif",
                                "Room");

                sceneMedbay.setScene(
                                true,
                                "Medbay (Revisited)",
                                "Kamu kembali ke Medbay, sebagian besar fasilitas tetap kosong",
                                "Room");

                Scene sceneEngineElectrical = new Scene(
                                "Engine / Electrical Room",
                                "Ruang besar tempat mesin utama dan panel kelistrikan Avalon",
                                "Room");

                sceneEngineElectrical.setScene(
                                true,
                                "Engine / Electrical (Revisited)",
                                "Kamu kembali ke ruang mesin, suara dengung masih terdengar",
                                "Room");

                Scene sceneReactorCore = new Scene(
                                "Reactor Core",
                                "Inti reaktor Avalon yang mengalami kerusakan kritis, alarm dan lampu darurat berkedip",
                                "Final");

                sceneReactorCore.setScene(
                                true,
                                "Reactor Core (Revisited)",
                                "Kamu kembali ke inti reaktor, panas dan radiasi masih mengancam",
                                "Final");

                // ======================= Passanger Cryo Bay ==========================

                scenePCB.setChoices(
                                "A", false,
                                "Periksa loker darurat (ambil Toolkit)",
                                scenePCB, 0, 1,
                                "Menemukan Toolkit di loker, siap untuk reparasi",
                                "Toolkit", null,
                                0, 0, null,
                                null,
                                null,
                                null);
                scenePCB.setChoices(
                                "A", true,
                                "Loker darurat kosong",
                                scenePCB, 0, 0,
                                "Loker sudah kosong, Toolkit tidak ada lagi",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                scenePCB.setChoices(
                                "B", false,
                                "Gunakan terminal komputer",
                                scenePCB, 1, 2,
                                "Membaca log error navigasi dan pendingin reaktor, ada percikan listrik",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                scenePCB.setChoices(
                                "B", true,
                                "Gunakan terminal kembali",
                                scenePCB, 0, 0,
                                "Tidak ada data baru, hanya log yang sama",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                scenePCB.setChoices(
                                "C", false,
                                "Periksa pod penumpang lain",
                                scenePCB, 0, 0,
                                "Semua pod terkunci, penumpang masih tertidur",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                scenePCB.setChoices(
                                "C", true,
                                "Cek ulang pod penumpang lain",
                                scenePCB, 0, 0,
                                "Tetap terkunci, tidak ada perubahan",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                scenePCB.setChoices(
                                "D", false,
                                "Keluar menuju Hallway L1",
                                sceneL1, 1, 0,
                                "Meninggalkan ruangan cryo, menuju lorong utama kapal",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                scenePCB.setChoices(
                                "D", true,
                                "Kembali ke Hallway L1",
                                sceneL1, 0, 0,
                                "Kembali ke lorong utama tanpa menemukan hal baru di cryo bay",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                // =============================== HALLWAY 1 ================================

                sceneL1.setChoices(
                                "A", false,
                                "Pergi ke Passenger Cryosleep Bay",
                                scenePCB, 1, 0,
                                "Berjalan menuju ruangan cryo penumpang, berharap menemukan petunjuk awal",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL1.setChoices(
                                "A", true,
                                "Kembali ke Passenger Cryosleep Bay",
                                scenePCB, 0, 0,
                                "Melangkah kembali menuju ruangan cryo penumpang yang sudah familiar",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL1.setChoices(
                                "B", false,
                                "Masuk ke Admin",
                                sceneAdmin, 1, 0,
                                "Membuka pintu ke ruangan Admin, tempat log misi dan arsip penting disimpan",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL1.setChoices(
                                "B", true,
                                "Kembali ke Admin",
                                sceneAdmin, 0, 0,
                                "Kembali melangkah ke ruang Admin, yang tampak lebih sunyi di kedua kalinya",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL1.setChoices(
                                "C", false,
                                "Menuju Cargo Bay",
                                sceneCargoBay, 1, 0,
                                "Mendorong pintu berat ke Cargo Bay, mendengar gema langkahmu di ruangan luas",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL1.setChoices(
                                "C", true,
                                "Kembali ke Cargo Bay",
                                sceneCargoBay, 0, 0,
                                "Menyusuri lorong yang sama menuju Cargo Bay, menghindari puing yang berserakan",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL1.setChoices(
                                "D", false,
                                "Pergi ke Crew CryoSleep",
                                sceneCrewCryo, 1, 0,
                                "Melangkah ke ruang cryo awak kapal. Mungkin ada kru yang bisa dibangunkan",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL1.setChoices(
                                "D", true,
                                "Kembali ke Crew CryoSleep",
                                sceneCrewCryo, 0, 0,
                                "Kembali ke ruangan cryo kru, jalurnya sudah lebih dikenali",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL1.setChoices(
                                "E", false,
                                "Lanjut ke Cockpit",
                                sceneCockpit, 1, 0,
                                "Menapaki koridor sempit menuju Cockpit, pusat kendali dan navigasi kapal",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL1.setChoices(
                                "E", true,
                                "Kembali ke Cockpit",
                                sceneCockpit, 0, 0,
                                "Kembali menelusuri jalur menuju Cockpit, langkahmu lebih mantap dibanding sebelumnya",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                // =========================== ADMIN ===============================

                sceneAdmin.setChoices(
                                "A", false,
                                "Buka arsip misi",
                                sceneAdmin, 0, 1,
                                "Membaca detail misi koloni Avalon dan catatan perjalanan",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneAdmin.setChoices(
                                "A", true,
                                "Arsip misi (ulang)",
                                sceneAdmin, 0, 0,
                                "Arsip sama, tidak ada info baru",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneAdmin.setChoices(
                                "B", false,
                                "Cek log aktivitas kru",
                                sceneAdmin, 0, 1,
                                "Mendapatkan catatan rutinitas kru, kapten terakhir masuk cryo",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneAdmin.setChoices(
                                "B", true,
                                "Cek log aktivitas kru (ulang)",
                                sceneAdmin, 0, 0,
                                "Tidak ada log baru, data sudah terbaca sebelumnya",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneAdmin.setChoices(
                                "C", false,
                                "Periksa lemari penyimpanan dokumen",
                                sceneAdmin, 0, 0,
                                "Menemukan CaptainAcessCard disimpan rapat di dalam dokumen",
                                "CaptainAcessCard", null,
                                0, 0, null,
                                null,
                                null,
                                Map.of("hasAccessCard", true));

                sceneAdmin.setChoices(
                                "C", true,
                                "Periksa lemari (ulang)",
                                sceneAdmin, 0, 0,
                                "Lemari kosong, dokumen penting sudah diambil",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneAdmin.setChoices(
                                "D", false,
                                "Kembali ke Hallway L1",
                                sceneL1, 0, 0,
                                "Menutup arsip dan keluar, kembali ke lorong utama",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneAdmin.setChoices(
                                "D", true,
                                "Kembali ke Hallway L1",
                                sceneL1, 0, 0,
                                "Kamu kembali ke lorong, tidak menemukan hal baru di Admin",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                // ======================= CARGO BAY =====================

                sceneCargoBay.setChoices(
                                "A", false,
                                "Periksa Escape Pod (aktifkan SelfishEnding)",
                                sceneCargoBay, 0, 0,
                                "Menemukan Escape Pod yang masih berfungsi, siap jadi jalur kabur sendirian",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                Map.of("SelfishActive", true));

                sceneCargoBay.setChoices(
                                "A", true,
                                "Escape Pod sudah diperiksa",
                                sceneCargoBay, 0, 0,
                                "Pod tak berubah, tetap menunggu jika kamu ingin kabur sendirian",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCargoBay.setChoices(
                                "B", false,
                                "Terminal informasi kargo",
                                sceneCargoBay, 0, 1,
                                "Membaca log inventaris, menambah pengetahuanmu tentang distribusi barang",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCargoBay.setChoices(
                                "B", true,
                                "Terminal informasi (ulang)",
                                sceneCargoBay, 0, 0,
                                "Data sama, tidak ada info baru",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCargoBay.setChoices(
                                "C", false,
                                "Kembali ke Hallway L1",
                                sceneL1, 0, 0,
                                "Meninggalkan Cargo Bay, melangkah kembali menuju lorong utama",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCargoBay.setChoices(
                                "C", true,
                                "Kembali ke Hallway L1",
                                sceneL1, 0, 0,
                                "Mengambil jalur yang sama, tidak menemukan hal lain",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCargoBay.setChoices(
                                "D", false,
                                "Menuju Hallway L2",
                                sceneL2, 0, 0,
                                "Melangkah keluar Cargo Bay ke Hallway L2, lokasi maintenance dan mesin",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCargoBay.setChoices(
                                "D", true,
                                "Menuju Hallway L2",
                                sceneL2, 0, 0,
                                "Berjalan lagi ke Hallway L2, jalur sama seperti sebelumnya",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                // ======================= Crew Cryosleep Bay ==========================

                sceneCrewCryo.setChoices(
                                "A", false,
                                "Bangunkan Aurora",
                                sceneCrewCryo, 1, 3,
                                "Mencoba membuka pod Aurora secara manual, menanggung risiko kecil",
                                null, null,
                                5, 16, "Toolkit",
                                Map.of(),
                                "Kamu perlu mempelajari Cryo terlebih dahulu sebelum bisa membangunkan Aurora",
                                Map.of("isAuroraAwake", true));

                sceneCrewCryo.setChoices(
                                "A", true,
                                "Aurora sudah terbangun",
                                sceneCrewCryo, 0, 0,
                                "Aurora berdiri di dekatmu, podnya terbuka dan penuh embun beku",
                                null, null,
                                0, 0, null,
                                Map.of("isAuroraAwake", true),
                                null,
                                null);

                sceneCrewCryo.setChoices(
                                "B", false,
                                "Periksa pod kru lainnya",
                                sceneCrewCryo, 0, 0,
                                "Pod lain terkunci, tak ada yang bisa dibuka tanpa akses kapten",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCrewCryo.setChoices(
                                "B", true,
                                "Tetap terkunci",
                                sceneCrewCryo, 0, 0,
                                "Keadaan pod lain tak berubah, semuanya terkunci",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCrewCryo.setChoices(
                                "C", false,
                                "Terminal status kru",
                                sceneCrewCryo, 0, 1,
                                "Mengecek data vital kru, mayoritas dalam kondisi stabil",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCrewCryo.setChoices(
                                "C", true,
                                "Terminal (ulang)",
                                sceneCrewCryo, 0, 0,
                                "Tidak ada info tambahan, data kru sama seperti sebelumnya",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCrewCryo.setChoices(
                                "D", false,
                                "Kembali ke Hallway L1",
                                sceneL1, 0, 0,
                                "Meninggalkan Crew Cryo, kembali ke lorong utama",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCrewCryo.setChoices(
                                "D", true,
                                "Kembali ke Hallway L1",
                                sceneL1, 0, 0,
                                "Kamu berjalan lagi ke Hallway L1, tanpa hal baru",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                // =========================== SCENE COCKPIT ===========================

                sceneCockpit.setChoices(
                                "A", false,
                                "Gunakan Terminal Navigasi",
                                sceneCockpit, 0, 1,
                                "Membaca data rute menuju Homestead, kalkulasi jarak masih lama",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCockpit.setChoices(
                                "A", true,
                                "Terminal Navigasi (ulang)",
                                sceneCockpit, 0, 0,
                                "Data sama, tidak ada perubahan",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCockpit.setChoices(
                                "B", false,
                                "Aktifkan Auto-Repair System (Butuh Toolkit)",
                                sceneCockpit, 1, 3,
                                "Menyalakan protokol perbaikan otomatis. Bisa memperlambat kerusakan sistem",
                                null, null,
                                0, 10, "Toolkit",
                                null,
                                "Butuh XP ≥ 10 dan Toolkit",
                                Map.of("autoRepairActive", true));

                sceneCockpit.setChoices(
                                "B", true,
                                "Auto-Repair sudah aktif",
                                sceneCockpit, 0, 0,
                                "Sistem Auto-Repair sedang berjalan, tidak ada yang perlu kamu lakukan",
                                null, null,
                                0, 0, null,
                                Map.of("autoRepairActive", true),
                                null,
                                null);

                sceneCockpit.setChoices(
                                "C", false,
                                "Buka Arsip Log Kapten",
                                sceneCockpit, 0, 1,
                                "Membaca catatan terakhir kapten sebelum cryo, info asteroid",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCockpit.setChoices(
                                "C", true,
                                "Log Kapten (ulang)",
                                sceneCockpit, 0, 0,
                                "Tidak ada data tambahan, semua sudah terbaca",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCockpit.setChoices(
                                "D", false,
                                "Kembali ke Hallway L1",
                                sceneL1, 0, 0,
                                "Menutup panel dan keluar, kembali ke lorong utama",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneCockpit.setChoices(
                                "D", true,
                                "Kembali ke Hallway L1",
                                sceneL1, 0, 0,
                                "Melangkah cepat, meninggalkan ruang kendali yang semakin familiar",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                // =========================== SCENE HALLWAY L2 ===========================

                sceneL2.setChoices(
                                "A", false,
                                "Masuk ke Maintenance Section",
                                sceneMaintenance, 1, 0,
                                "Menuju area Maintenance untuk memperbaiki panel listrik dan sistem lain",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL2.setChoices(
                                "A", true,
                                "Kembali ke Maintenance",
                                sceneMaintenance, 0, 0,
                                "Jalur yang sama ke Maintenance, tak ada hal baru di lorong ini",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL2.setChoices(
                                "B", false,
                                "Masuk ke Medbay",
                                sceneMedbay, 0, 0,
                                "Lorong gelap membawa ke Medbay, tempat sistem medis otomatis berada",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL2.setChoices(
                                "B", true,
                                "Kembali ke Medbay",
                                sceneMedbay, 0, 0,
                                "Menyusuri jalur yang sama menuju Medbay",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL2.setChoices(
                                "C", false,
                                "Pergi ke Engine/Electrical",
                                sceneEngineElectrical, 1, 0,
                                "Berjalan ke ruang mesin, mendengar suara dentuman kecil di kejauhan",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL2.setChoices(
                                "C", true,
                                "Kembali ke Engine/Electrical",
                                sceneEngineElectrical, 0, 0,
                                "Lorong yang sama, tidak ada kejutan berarti",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL2.setChoices(
                                "D", false,
                                "Kembali ke Cargo Bay",
                                sceneCargoBay, 0, 0,
                                "Balik arah menuju Cargo Bay, menyeberangi lorong panjang",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneL2.setChoices(
                                "D", true,
                                "Kembali ke Cargo Bay",
                                sceneCargoBay, 0, 0,
                                "Jalur kembali yang sama, suasana masih mencekam",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                // =========================== SCENE MAINTENANCE ===========================

                sceneMaintenance.setChoices(
                                "A", false,
                                "Perbaiki Panel Listrik (Turunkan risiko navigasi)",
                                sceneMaintenance, 0, 2,
                                "Berhasil memperbaiki panel listrik, menurunkan risiko damage dari 40% menjadi 30%",
                                null, null,
                                0, 0, "Toolkit",
                                null,
                                "Butuh Toolkit untuk memperbaiki panel",
                                Map.of("isElectricalFix", true));

                sceneMaintenance.setChoices(
                                "A", true,
                                "Panel Listrik sudah diperbaiki",
                                sceneMaintenance, 0, 0,
                                "Panel listrik stabil, tidak perlu diperbaiki lagi",
                                null, null,
                                0, 0, null,
                                Map.of("isElectricalFix", true),
                                null,
                                null);

                sceneMaintenance.setChoices(
                                "B", false,
                                "Isi Ulang PowerCell",
                                sceneMaintenance, 0, 1,
                                "Mengisi ulang PowerCell, siap digunakan untuk reaktor. PowerCell terpakai setelah ini",
                                null, "PowerCell",
                                0, 0, null,
                                Map.of("hasPowerCell", true, "PowercellCharged", false),
                                "Butuh PowerCell belum terisi",
                                Map.of("PowercellCharged", true));

                sceneMaintenance.setChoices(
                                "B", true,
                                "PowerCell sudah terisi",
                                sceneMaintenance, 0, 0,
                                "Tidak perlu diisi lagi, cadangan daya sudah maksimal",
                                null, null,
                                0, 0, null,
                                Map.of("PowercellCharged", true),
                                null,
                                null);

                sceneMaintenance.setChoices(
                                "C", false,
                                "Terminal Diagnostik Mesin",
                                sceneMaintenance, 0, 1,
                                "Menemukan data kerusakan serius pada reaktor, perlu penanganan cepat",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneMaintenance.setChoices(
                                "C", true,
                                "Terminal Diagnostik (ulang)",
                                sceneMaintenance, 0, 0,
                                "Data sama, tidak ada yang baru",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneMaintenance.setChoices(
                                "D", false,
                                "Kembali ke Hallway L2",
                                sceneL2, 0, 0,
                                "Meninggalkan Maintenance Section, kembali ke lorong",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneMaintenance.setChoices(
                                "D", true,
                                "Kembali ke Hallway L2",
                                sceneL2, 0, 0,
                                "Balik ke lorong yang sama, tidak ada hal lain di Maintenance Section",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                // =========================== SCENE MEDBAY ===========================

                sceneMedbay.setChoices(
                                "A", false,
                                "Gunakan Sistem Medis Otomatis",
                                sceneMedbay, -3, 0,
                                "Kamu merasakan suntikan penambah vitalitas. Health +3",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneMedbay.setChoices(
                                "A", true,
                                "Sistem Medis sudah digunakan",
                                sceneMedbay, 0, 0,
                                "Tidak ada lagi obat tersedia di sistem otomatis",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneMedbay.setChoices(
                                "B", false,
                                "Periksa Terminal Medis",
                                sceneMedbay, 0, 1,
                                "Menemukan informasi singkat kondisi kru yang masih cryo-stabil",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneMedbay.setChoices(
                                "B", true,
                                "Terminal Medis (ulang)",
                                sceneMedbay, 0, 0,
                                "Data sama, kru dalam keadaan stabil",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneMedbay.setChoices(
                                "C", false,
                                "Cek Penyimpanan Medis",
                                sceneMedbay, 0, 0,
                                "Laci obat dan alat medis kosong, tampaknya sudah terpakai",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneMedbay.setChoices(
                                "C", true,
                                "Penyimpanan Medis (ulang)",
                                sceneMedbay, 0, 0,
                                "Tetap kosong, tidak ada apa-apa",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneMedbay.setChoices(
                                "D", false,
                                "Kembali ke Hallway L2",
                                sceneL2, 0, 0,
                                "Meninggalkan Medbay, kembali ke lorong utama",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneMedbay.setChoices(
                                "D", true,
                                "Kembali ke Hallway L2",
                                sceneL2, 0, 0,
                                "Balik lagi ke lorong, Medbay tak menawarkan hal baru",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                // ====================== SCENE ENGINE / ELECTRICAL ROOM =======================

                sceneEngineElectrical.setChoices(
                                "A", false,
                                "Stabilisasi tekanan mesin (Butuh Toolkit)",
                                sceneEngineElectrical, 1, 2,
                                "Berhasil menyeimbangkan tekanan mesin, menurunkan risiko navigasi menjadi 20%",
                                null, null,
                                0, 0, "Toolkit",
                                null,
                                null,
                                Map.of("engineStabilized", true));

                sceneEngineElectrical.setChoices(
                                "A", true,
                                "Tekanan mesin sudah stabil",
                                sceneEngineElectrical, 0, 0,
                                "Tekanan mesin berada di kondisi optimal. Tidak perlu penyesuaian lagi",
                                null, null,
                                0, 0, null,
                                Map.of("engineStabilized", true),
                                null,
                                null);

                sceneEngineElectrical.setChoices(
                                "B", false,
                                "Terminal monitor mesin (sekali XP)",
                                sceneEngineElectrical, 0, 1,
                                "Membaca prioritas utama: perbaikan Reactor Core. Mesin bakal overload jika reaktor dibiarkan rusak",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneEngineElectrical.setChoices(
                                "B", true,
                                "Monitor mesin (ulang)",
                                sceneEngineElectrical, 0, 0,
                                "Tidak ada informasi baru, data sama",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneEngineElectrical.setChoices(
                                "C", false,
                                "Kotak penyimpanan (ambil PowerCell)",
                                sceneEngineElectrical, 0, 0,
                                "Menemukan PowerCell cadangan di kotak logam tersegel",
                                "PowerCell", null,
                                0, 0, null,
                                Map.of("hasPowerCell", false),
                                "Hanya bisa ambil satu PowerCell",
                                Map.of("hasPowerCell", true));

                sceneEngineElectrical.setChoices(
                                "C", true,
                                "Kotak penyimpanan kosong",
                                sceneEngineElectrical, 0, 0,
                                "Kotak penyimpanan sudah kosong, PowerCell sudah diambil",
                                null, null,
                                0, 0, null,
                                Map.of("hasPowerCell", true),
                                null,
                                null);

                sceneEngineElectrical.setChoices(
                                "D", false,
                                "Masuk ke Reactor Core (Butuh Access Card?)",
                                sceneReactorCore, 0, 0,
                                "Mendorong pintu berat menuju inti reaktor, tempat krisis berlangsung",
                                null, null,
                                0, 0, null,
                                Map.of("hasAccessCard", true),
                                "Butuh Access Card untuk masuk",
                                null);

                sceneEngineElectrical.setChoices(
                                "D", true,
                                "Kembali ke Reactor Core",
                                sceneReactorCore, 0, 0,
                                "Jalan yang sama, menembus panas dan radiasi reaktor",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneEngineElectrical.setChoices(
                                "E", false,
                                "Kembali ke Hallway L2",
                                sceneL2, 0, 0,
                                "Menjauh dari ruang mesin, kembali ke lorong",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneEngineElectrical.setChoices(
                                "E", true,
                                "Kembali ke Hallway L2",
                                sceneL2, 0, 0,
                                "Tidak ada perubahan baru di Engine/Electrical",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                // =========================== SCENE REACTOR CORE ===========================

                sceneReactorCore.setChoices(
                                "A", false,
                                "Gunakan Escape Pod (Selfish Ending)",
                                sceneEndingSelfish, 0, 0,
                                "Kamu memutuskan kabur sendiri, meninggalkan reaktor dan para penumpang",
                                null, null,
                                0, 0, null,
                                Map.of("SelfishActive", true),
                                "Escape Pod harus diaktifkan di Cargo Bay",
                                null);

                sceneReactorCore.setChoices(
                                "A", true,
                                "Sudah kabur (Selfish)",
                                sceneEndingSelfish, 0, 0,
                                "Keputusanmu sudah dibuat, tak ada jalan kembali",
                                null, null,
                                0, 0, null,
                                Map.of("SelfishActive", true),
                                null,
                                null);

                sceneReactorCore.setChoices(
                                "B", false,
                                "Perbaiki bersama Aurora (Mutual Ending)",
                                sceneEndingMutual, 3, 5,
                                "Kamu dan Aurora bekerja sama menstabilkan reaktor. Kalian berhasil menyelamatkan semua, tapi butuh usaha keras",
                                null, null,
                                5, 10, "Toolkit",
                                Map.of("isAuroraAwake", true, "hasPowerCell", true),
                                "Butuh Aurora awake, XP≥10, PowerCell, dan Toolkit",
                                null);

                sceneReactorCore.setChoices(
                                "B", true,
                                "Reaktor sudah distabilkan bersama Aurora",
                                sceneEndingMutual, 0, 0,
                                "Kalian telah mengamankan reaktor, tidak ada lagi yang bisa diperbaiki di sini",
                                null, null,
                                0, 0, null,
                                Map.of("isAuroraAwake", true),
                                null,
                                null);

                sceneReactorCore.setChoices(
                                "C", false,
                                "Korbankan diri (Heroic Ending)",
                                sceneEndingHeroic, 6, 10,
                                "Kamu mengerahkan seluruh kemampuan, mengunci diri di ruang radiasi demi menyalakan protokol penuh. Kapal selamat, tapi tidak bagimu",
                                null, null,
                                8, 20, "Toolkit",
                                Map.of("autoRepairActive", true, "hasAccessCard", true, "PowercellCharged", true),
                                "Butuh XP≥20, autoRepairActive, Access Card, PowerCellCharged",
                                null);

                sceneReactorCore.setChoices(
                                "C", true,
                                "Reaktor aman (Heroic tuntas)",
                                sceneEndingHeroic, 0, 0,
                                "Pengorbananmu telah menyelamatkan ribuan nyawa, tapi kamu tak bisa kembali",
                                null, null,
                                0, 0, null,
                                Map.of("autoRepairActive", true, "hasAccessCard", true, "PowercellCharged", true),
                                null,
                                null);

                sceneReactorCore.setChoices(
                                "D", false,
                                "Coba sebisa kamu!",
                                sceneEndingDeath, 10, 0,
                                "Usahamu berakhir kacau, reaktor meledak, Avalon hancur total",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                sceneReactorCore.setChoices(
                                "D", true,
                                "Tidak ada jalan kembali (Death)",
                                sceneEndingDeath, 0, 0,
                                "Reaktor sudah menuju kehancuran, tak ada yang bisa mengubahnya",
                                null, null,
                                0, 0, null,
                                null,
                                null,
                                null);

                Character testCharacter = new Character("TestPlayer", 16);

                Story story = new Story(scenePCB, testCharacter);

                // flag player
                testCharacter.setFlag("isAuroraAwake", false);
                testCharacter.setFlag("isElectricalFix", false);
                testCharacter.setFlag("engineStabilized", false);
                testCharacter.setFlag("hasPowerCell", false);
                testCharacter.setFlag("PowercellCharged", false);
                testCharacter.setFlag("autoRepairActive", false);
                testCharacter.setFlag("SelfishActive", false);
                testCharacter.setFlag("hasAccessCard", false);

                story.start();
        }
}