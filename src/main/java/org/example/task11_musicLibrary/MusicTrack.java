package org.example.task11_musicLibrary;

/**
 * Создайте класс MusicTrack c полями для названия трека, исполнителя и жанра
 * В классе MusicLibrary используйте HashMap<String, HashSet<MusicTrack>> для организации музыка
 * Реализуйте методы для добавления трека в библиотеку, уделения трека из библиотеки и получения всех треков заданного жанра
 */
public class MusicTrack {
    private String track;
    private String performer;
    private String genre;

    public MusicTrack(String track, String performer) {
        this.track = track;
        this.performer = performer;
    }

    @Override
    public String toString() {
        return "MusicTrack{" +
                "track='" + track + '\'' +
                ", performer='" + performer + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }


}
