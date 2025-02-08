package org.example.task11_musicLibrary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MusicLibrary {
    HashMap<String, HashSet<MusicTrack>> musicLibrary = new HashMap<>();

    public void addTrack(String genre, MusicTrack musicTrack){
        if(!musicLibrary.containsKey(genre)){
            musicLibrary.put(genre, new HashSet<>());
        }
        musicLibrary.get(genre).add(musicTrack);
    }

    public void removeTrack(MusicTrack musicTrack){
        for(Map.Entry <String, HashSet<MusicTrack>> entry : musicLibrary.entrySet()){
            HashSet<MusicTrack> tracks = entry.getValue();
            if(tracks.contains(musicTrack) && tracks.size()>1) {
                tracks.remove(musicTrack);
            }
            if (tracks.contains(musicTrack) && tracks.size()==1) {
                musicLibrary.remove(entry.getKey());
            }
        }
    }

    //получение треков по жанру
    public HashSet<MusicTrack> getTracksOfGenre(String genre) {
        return musicLibrary.getOrDefault(genre, new HashSet<>());
    }
    //получение  жанра по треку
    public void getGenreOfTracks(MusicTrack musicTrack){
        for(Map.Entry <String, HashSet<MusicTrack>> entry : musicLibrary.entrySet()){
            if(entry.getValue().contains(musicTrack)){
                System.out.println(entry.getKey());
            }
        }
    }

    public void getMusicLibrary(){
        for(Map.Entry <String, HashSet<MusicTrack>> entry : musicLibrary.entrySet()){
            System.out.println(entry);
        }
    }


}
