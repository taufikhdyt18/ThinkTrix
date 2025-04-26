package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity1 extends AppCompatActivity {


    private TextView questionText;
    private TextView levelText;
    private TextView scoreText;
    private Button option1Button, option2Button, option3Button, restartButton, mainMenuButton;

    // Quiz data for multiple levels with 6 questions each
    private String[][] levelQuestions = {
            // Level 1
            {
                    "Apa ibu kota Indonesia?",
                    "Berapa hasil dari 2 + 2?",
                    "Siapa presiden pertama Indonesia?",
                    "Apa warna bendera Indonesia?",
                    "Semboyan Indonesia adalah Bhinneka Tunggal?",
                    "Hari kemerdekaan Indonesia diperingati setiap tanggal?"
            },
            // Level 2
            {
                    "Benua terbesar di dunia adalah?",
                    "Planet terdekat dengan matahari adalah?",
                    "Unsur kimia dengan simbol O adalah?",
                    "Berapa jumlah planet di tata surya kita?",
                    "Apa nama samudra terluas di dunia?",
                    "Negara dengan penduduk terbanyak di dunia adalah?"
            },
            // Level 3
            {
                    "Siapakah pengarang novel 'Laskar Pelangi'?",
                    "Danau terdalam di dunia adalah?",
                    "Sungai terpanjang di dunia adalah?",
                    "Pulau terbesar di Indonesia adalah?",
                    "Hewan nasional Indonesia adalah?",
                    "Bahasa pemrograman yang dibuat oleh James Gosling adalah?"
            },
            // Level 4
            {
                    "Tahun berapa Indonesia merdeka?",
                    "Berapa jumlah provinsi di Indonesia saat ini?",
                    "Siapa penemu bola lampu?",
                    "Apa nama mata uang Indonesia?",
                    "Berapa jumlah sila dalam Pancasila?",
                    "Apa singkatan dari WHO?"
            },
            // Level 5
            {
                    "Apa nama mata uang Jepang?",
                    "Apa ibukota Australia?",
                    "Apa nama alat musik tradisional dari Jawa Barat?",
                    "Siapa ilmuwan yang menemukan teori relativitas?",
                    "Berapa jumlah total kartu dalam setumpuk kartu remi standar?",
                    "Apa nama lapisan atmosfer terluar bumi?"
            },
            // Level 6
            {
                    "Berapa hasil dari 15 × 7?",
                    "Siapa pelukis Mona Lisa?",
                    "Gunung tertinggi di Indonesia adalah?",
                    "Apa nama planet terbesar di tata surya kita?",
                    "Berapa jumlah sisi pada sebuah kubus?",
                    "Apa unsur kimia dengan simbol Fe?"
            },
            // Level 7
            {
                    "Apa nama ibu kota Thailand?",
                    "Siapa penulis 'Harry Potter'?",
                    "Apa unsur kimia dengan simbol Au?",
                    "Planet keempat dari matahari adalah?",
                    "Apa satuan arus listrik?",
                    "Dimana Candi Borobudur berada?"
            },
            // Level 8
            {
                    "Siapa penemu telepon?",
                    "Apa nama sungai terpanjang di Asia?",
                    "Benua terkecil di dunia adalah?",
                    "Apa nama lapisan bumi yang paling luar?",
                    "Apa ibukota Vietnam?",
                    "Apa simbol kimia dari air?"
            },
            // Level 9
            {
                    "Organ manusia yang memompa darah adalah?",
                    "Ibukota negara Mesir adalah?",
                    "Apa nama gas yang kita hirup untuk bernapas?",
                    "Apa alat musik tiup dari Sumatera Barat?",
                    "Apa nama hewan tercepat di darat?",
                    "Apa fungsi ginjal dalam tubuh manusia?"
            },
            // Level 10
            {
                    "Hewan berkaki dua disebut?",
                    "Siapa pelukis terkenal dari Belanda?",
                    "Berapa sisi segitiga sama sisi?",
                    "Satuan tekanan adalah?",
                    "Ibukota Rusia adalah?",
                    "Unsur dengan simbol C adalah?"
            },
            // Level 11
            {
                    "Apa nama alat untuk mengukur suhu?",
                    "Berapa derajat sudut siku-siku?",
                    "Apa nama sungai di Kalimantan yang terkenal?",
                    "Ibukota negara Brazil?",
                    "Alat musik tradisional Bali?",
                    "Berapakah hasil dari 81 ÷ 9?"
            },
            // Level 12
            {
                    "Siapa penulis novel 'Bumi'?",
                    "Apa nama bahasa pemrograman untuk web?",
                    "Planet yang punya cincin paling mencolok?",
                    "Apa bentuk bumi sebenarnya?",
                    "Apa nama alat untuk melihat benda kecil?",
                    "Berapa kaki laba-laba?"
            },
            // Level 13
            {
                    "Unsur kimia dengan simbol Na?",
                    "Ibukota Kanada?",
                    "Siapa penemu pesawat terbang?",
                    "Apa warna daun saat musim gugur?",
                    "Benda langit yang mengelilingi planet disebut?",
                    "Alat pengukur berat badan adalah?"
            },
            // Level 14
            {
                    "Sungai terpanjang di Indonesia?",
                    "Ibukota Malaysia adalah?",
                    "Hewan laut terbesar?",
                    "Planet terdingin di tata surya?",
                    "Bahasa resmi Brazil?",
                    "Alat musik khas Papua?"
            },
            // Level 15
            {
                    "Apa nama zat yang membuat makanan terasa manis?",
                    "Ibukota Italia?",
                    "Nama benua yang ada di Kutub Selatan?",
                    "Warna pelangi yang paling luar?",
                    "Planet yang dikenal sebagai bintang pagi?",
                    "Nama ilmiah manusia adalah?"
            },
            // Level 16
            {
                    "Berapakah 9 × 8?",
                    "Negara dengan piramida terkenal?",
                    "Alat yang digunakan untuk mengukur panjang?",
                    "Planet yang punya kehidupan?",
                    "Simbol kimia dari karbon dioksida?",
                    "Binatang yang bertelur disebut?"
            },
            // Level 17
            {
                    "Negara yang terkenal dengan Menara Eiffel?",
                    "Siapa yang membuat lukisan 'The Starry Night'?",
                    "Berapa jumlah tulang pada tubuh manusia dewasa?",
                    "Apa warna darah manusia?",
                    "Hewan berkantung dari Australia?",
                    "Hewan yang hidup di dua alam?"
            },
            // Level 18
            {
                    "Ibukota Korea Selatan?",
                    "Siapa pendiri Microsoft?",
                    "Simbol kimia dari garam dapur?",
                    "Satuan untuk energi?",
                    "Apa nama tulang kepala?",
                    "Negara kepulauan terbesar di dunia?"
            },
            // Level 19
            {
                    "Apa simbol kimia dari Perak?",
                    "Siapa penemu hukum gravitasi?",
                    "Berapa jumlah bulan bumi?",
                    "Apa bentuk orbit planet?",
                    "Planet dengan rotasi tercepat?",
                    "Gunung tertinggi di dunia?"
            },
            // Level 20
            {
                    "Siapa penulis novel 'Ayat-Ayat Cinta'?",
                    "Apa nama ibu kota Argentina?",
                    "Negara yang terkenal dengan opera?",
                    "Berapakah 7 + 6 × 2?",
                    "Planet yang berwarna merah?",
                    "Bahasa resmi di Mesir?"
            }
    };


    private String[][][] levelOptions = {
            {
                    {"Jakarta", "Bandung", "Surabaya"},
                    {"3", "4", "5"},
                    {"Soekarno", "Soeharto", "Jokowi"},
                    {"Merah Putih", "Putih Merah", "Merah Biru"},
                    {"Ika", "Eka", "Wika"},
                    {"17 Agustus", "1 Juni", "28 Oktober"}
            },
            {
                    {"Asia", "Afrika", "Amerika Utara"},
                    {"Merkurius", "Venus", "Mars"},
                    {"Oksigen", "Emas", "Osmium"},
                    {"8", "9", "7"},
                    {"Samudra Pasifik", "Samudra Atlantik", "Samudra Hindia"},
                    {"China", "India", "Amerika Serikat"}
            },
            {
                    {"Andrea Hirata", "Tere Liye", "Dee Lestari"},
                    {"Danau Baikal", "Danau Toba", "Danau Superior"},
                    {"Sungai Nil", "Sungai Amazon", "Sungai Yangtze"},
                    {"Kalimantan", "Sumatera", "Papua"},
                    {"Komodo", "Elang Jawa", "Harimau Sumatera"},
                    {"Java", "Python", "C++"}
            },
            {
                    {"1945", "1949", "1950"},
                    {"34", "33", "36"},
                    {"Thomas Edison", "Nikola Tesla", "Albert Einstein"},
                    {"Rupiah", "Ringgit", "Peso"},
                    {"5", "4", "6"},
                    {"World Health Organization", "World Human Organization", "World Help Organization"}
            },
            {
                    {"Yen", "Won", "Yuan"},
                    {"Canberra", "Sydney", "Melbourne"},
                    {"Angklung", "Gamelan", "Sasando"},
                    {"Albert Einstein", "Isaac Newton", "Stephen Hawking"},
                    {"52", "48", "54"},
                    {"Eksosfer", "Stratosfer", "Troposfer"}
            },
            {
                    {"105", "95", "115"},
                    {"Leonardo da Vinci", "Pablo Picasso", "Vincent van Gogh"},
                    {"Puncak Jaya", "Gunung Kerinci", "Gunung Semeru"},
                    {"Jupiter", "Saturnus", "Mars"},
                    {"6", "8", "12"},
                    {"Besi", "Emas", "Perak"}
            },
            {
                    {"Bangkok", "Phuket", "Chiang Mai"},
                    {"J.K. Rowling", "Suzanne Collins", "Stephen King"},
                    {"Emas", "Perak", "Tembaga"},
                    {"Mars", "Venus", "Saturnus"},
                    {"Ampere", "Volt", "Ohm"},
                    {"Magelang", "Yogyakarta", "Solo"}
            },
            {
                    {"Alexander Graham Bell", "Thomas Edison", "Nikola Tesla"},
                    {"Yangtze", "Mekong", "Sungai Ob"},
                    {"Australia", "Eropa", "Antartika"},
                    {"Kerak", "Mantel", "Inti"},
                    {"Hanoi", "Ho Chi Minh", "Da Nang"},
                    {"H2O", "CO2", "O2"}
            },
            {
                    {"Jantung", "Paru-paru", "Lambung"},
                    {"Kairo", "Alexandria", "Giza"},
                    {"Oksigen", "Nitrogen", "Hidrogen"},
                    {"Saluang", "Suling", "Gamelan"},
                    {"Cheetah", "Kuda", "Singa"},
                    {"Menyaring darah", "Mencerna makanan", "Mengatur hormon"}
            },
            {
                    {"Bipedal", "Quadrupedal", "Amfibi"},
                    {"Vincent van Gogh", "Leonardo da Vinci", "Rembrandt"},
                    {"3", "4", "5"},
                    {"Pascal", "Newton", "Joule"},
                    {"Moskow", "St. Petersburg", "Kazan"},
                    {"Karbon", "Kalsium", "Silikon"}
            },
            {
                    {"Termometer", "Barometer", "Higrometer"},
                    {"90", "45", "180"},
                    {"Kapuas", "Mahakam", "Barito"},
                    {"Brasilia", "Rio de Janeiro", "Sao Paulo"},
                    {"Gamelan", "Angklung", "Rindik"},
                    {"9", "8", "7"}
            },
            {
                    {"Tere Liye", "Dewi Lestari", "Habiburrahman El Shirazy"},
                    {"HTML", "Python", "C++"},
                    {"Saturnus", "Jupiter", "Uranus"},
                    {"Bulat pepat", "Datar", "Kotak"},
                    {"Mikroskop", "Teleskop", "Lup"},
                    {"8", "6", "10"}
            },
            {
                    {"Natrium", "Neon", "Nikel"},
                    {"Ottawa", "Toronto", "Vancouver"},
                    {"Wright bersaudara", "Leonardo da Vinci", "Elon Musk"},
                    {"Merah", "Hijau", "Kuning"},
                    {"Satelit", "Asteroid", "Bintang"},
                    {"Timbangan", "Termometer", "Mikrometer"}
            },
            {
                    {"Kapuas", "Mahakam", "Musirawas"},
                    {"Kuala Lumpur", "Penang", "Johor Bahru"},
                    {"Paus Biru", "Hiu", "Lumba-lumba"},
                    {"Neptunus", "Uranus", "Mars"},
                    {"Portugis", "Spanyol", "Prancis"},
                    {"Tifa", "Sasando", "Kolintang"}
            },
            {
                    {"Gula", "Garam", "Cuka"},
                    {"Roma", "Venesia", "Milan"},
                    {"Antarktika", "Asia", "Afrika"},
                    {"Merah", "Violet", "Hijau"},
                    {"Venus", "Mars", "Saturnus"},
                    {"Homo sapiens", "Homo erectus", "Neanderthal"}
            },
            {
                    {"72", "81", "63"},
                    {"Mesir", "Yunani", "Turki"},
                    {"Penggaris", "Termometer", "Voltmeter"},
                    {"Bumi", "Mars", "Saturnus"},
                    {"CO2", "O2", "H2O"},
                    {"Ovipar", "Vivipar", "Amfibi"}
            },
            {
                    {"Prancis", "Italia", "Spanyol"},
                    {"Vincent van Gogh", "Claude Monet", "Leonardo da Vinci"},
                    {"206", "208", "210"},
                    {"Merah", "Biru", "Hijau"},
                    {"Kanguru", "Koala", "Wombat"},
                    {"Katak", "Kuda", "Ular"}
            },
            {
                    {"Seoul", "Busan", "Incheon"},
                    {"Bill Gates", "Steve Jobs", "Mark Zuckerberg"},
                    {"NaCl", "KCl", "MgCl"},
                    {"Joule", "Newton", "Watt"},
                    {"Tengkorak", "Tulang Belakang", "Tulang Rusuk"},
                    {"Indonesia", "Filipina", "Jepang"}
            },
            {
                    {"Ag", "Au", "Al"},
                    {"Isaac Newton", "Galileo Galilei", "Einstein"},
                    {"1", "2", "3"},
                    {"Elips", "Lingkaran", "Kotak"},
                    {"Jupiter", "Merkurius", "Saturnus"},
                    {"Everest", "K2", "Denali"}
            },
            {
                    {"Habiburrahman El Shirazy", "Andrea Hirata", "Tere Liye"},
                    {"Buenos Aires", "Santiago", "Lima"},
                    {"Italia", "Austria", "Spanyol"},
                    {"19", "26", "13"},
                    {"Mars", "Venus", "Merkurius"},
                    {"Arab", "Ibrani", "Inggris"}
            }
    };


    private int[][] levelCorrectAnswers = {
            {0, 1, 0, 0, 0, 0}, // Level 1
            {0, 0, 0, 0, 0, 0}, // Level 2
            {0, 0, 0, 2, 0, 0}, // Level 3
            {0, 0, 0, 0, 0, 0}, // Level 4
            {0, 0, 0, 0, 0, 0}, // Level 5
            {0, 0, 0, 0, 0, 0}, // Level 6
            {0, 0, 0, 0, 0, 0}, // Level 7
            {0, 1, 0, 0, 0, 0}, // Level 8
            {0, 0, 0, 0, 0, 0}, // Level 9
            {0, 2, 0, 1, 0, 0}, // Level 10
            {0, 0, 1, 0, 2, 0}, // Level 11
            {0, 0, 0, 0, 0, 0}, // Level 12
            {0, 0, 0, 0, 0, 0}, // Level 13
            {0, 0, 0, 0, 0, 0}, // Level 14
            {0, 0, 0, 0, 0, 0}, // Level 15
            {0, 0, 0, 0, 0, 0}, // Level 16
            {0, 0, 0, 0, 0, 0}, // Level 17
            {0, 0, 0, 0, 0, 0}, // Level 18
            {0, 0, 0, 0, 0, 0}, // Level 19
            {0, 0, 0, 1, 0, 0}  // Level 20
    };



    private int currentLevel = 0;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private int totalQuestions = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);

        // Get current level from intent
        currentLevel = getIntent().getIntExtra("LEVEL", 0);

        questionText = findViewById(R.id.questionText);
        levelText = findViewById(R.id.levelText);
        scoreText = findViewById(R.id.scoreText);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        restartButton = findViewById(R.id.restartButton);
        mainMenuButton = findViewById(R.id.mainMenuButton);

        // Set level text
        levelText.setText("Level " + (currentLevel + 0));

        // Calculate total questions in this level
        totalQuestions = levelQuestions[currentLevel].length;

        // Update score display
        updateScoreDisplay();

        // Load the first question
        loadQuestion();

        option1Button.setOnClickListener(view -> checkAnswer(0));
        option2Button.setOnClickListener(view -> checkAnswer(1));
        option3Button.setOnClickListener(view -> checkAnswer(2));

        restartButton.setOnClickListener(view -> {
            // Reset quiz variables
            currentQuestionIndex = 0;
            score = 0;

            // Enable answer buttons
            setAnswerButtonsEnabled(true);

            // Update score display
            updateScoreDisplay();

            // Load first question
            loadQuestion();

            // Hide result buttons
            restartButton.setVisibility(Button.GONE);
            mainMenuButton.setVisibility(Button.GONE);
        });

        mainMenuButton.setOnClickListener(view -> {
            // Return to main menu
            finish();
        });

        // Initially hide result buttons
        restartButton.setVisibility(Button.GONE);
        mainMenuButton.setVisibility(Button.GONE);
    }

    private void loadQuestion() {
        if (currentQuestionIndex < levelQuestions[currentLevel].length) {
            // Load question and options
            questionText.setText(levelQuestions[currentLevel][currentQuestionIndex]);
            option1Button.setText(levelOptions[currentLevel][currentQuestionIndex][0]);
            option2Button.setText(levelOptions[currentLevel][currentQuestionIndex][1]);
            option3Button.setText(levelOptions[currentLevel][currentQuestionIndex][2]);
        } else {
            // Quiz completed
            showResults();
        }
    }

    private void checkAnswer(int selectedOptionIndex) {
        // Check if answer is correct
        boolean isCorrect = (selectedOptionIndex == levelCorrectAnswers[currentLevel][currentQuestionIndex]);

        if (isCorrect) {
            // Increase score if correct
            score++;
            updateScoreDisplay();
            Toast.makeText(this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
        }

        // Move to next question
        currentQuestionIndex++;
        loadQuestion();
    }

    private void updateScoreDisplay() {
        scoreText.setText("Skor: " + score + "/" + totalQuestions);
    }

    private void showResults() {
        // Display results
        questionText.setText("Kuis selesai!\nAnda mendapatkan skor " + score + " dari " + totalQuestions);

        // Disable answer buttons
        setAnswerButtonsEnabled(false);

        // Show result buttons
        restartButton.setVisibility(Button.VISIBLE);
        mainMenuButton.setVisibility(Button.VISIBLE);
    }

    private void setAnswerButtonsEnabled(boolean enabled) {
        option1Button.setEnabled(enabled);
        option2Button.setEnabled(enabled);
        option3Button.setEnabled(enabled);
    }
}