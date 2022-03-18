package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        List<String> answerList = readPhrases();
        List<String> chat = new ArrayList<>();
        boolean flag = true;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Команды: закончить; стоп; продолжить;" + System.lineSeparator() + "Чат с ботом: ");
            String line = reader.readLine();

            while (!OUT.equals(line)) {
                while (!STOP.equals(line) && flag) {
                    Random random = new Random();
                    int randomPhraseIndex = random.nextInt(answerList.size());
                    String phrase = "Пользователь: " + line + "\n";
                    String pcAnswer = "Компьютер: " + answerList.get(randomPhraseIndex);
                    System.out.println(pcAnswer);
                    chat.add(phrase);
                    chat.add(pcAnswer);
                    chat.add(System.lineSeparator());
                    line = reader.readLine();
                    if (STOP.equals(line)) {
                        flag = false;
                    }
                    if (OUT.equals(line)) {
                        saveLog(chat);
                        return;
                    }
                }
                line = reader.readLine();
                if (CONTINUE.equals(line)) {
                    flag = true;
                }
            }
            saveLog(chat);
        }
    }

    private List<String> readPhrases() throws IOException {
        List<String> rsl = new ArrayList<>();

        Path pathAnswerPhrases = Paths.get(botAnswers);
        try (BufferedReader reader = new BufferedReader(new FileReader(pathAnswerPhrases.toFile(), StandardCharsets.UTF_8))) {
            reader.lines().forEach(rsl::add);
        }
        return rsl;
    }

    private void saveLog(List<String> log) throws IOException {
        Path logPath = Paths.get(path);
        try (PrintWriter writer = new PrintWriter(new FileWriter(logPath.toFile(), StandardCharsets.UTF_8))) {
            for (String str : log) {
                writer.write(str);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./data/chatBot.txt");
        String pathName = path.toString();
        Path botAnswers = Paths.get("./data/botAnswersName.txt");
        String botAnswersName = botAnswers.toString();
        ConsoleChat cc = new ConsoleChat(pathName, botAnswersName);
        cc.run();
    }
}
