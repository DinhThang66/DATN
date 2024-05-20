package org.example.project.gaSchedule.model;

// Stores data about classroom
public class Room
{
    private static int _nextRoomId = 0;

    public Room(String name, boolean lab, int numberOfSeats)
    {
        Id = _nextRoomId++;
        Name = name;
        Lab = lab;
        NumberOfSeats = numberOfSeats;
    }

    public int Id;

    public String Name;

    // Trả về TRUE nếu phòng có máy tính, ngược lại trả về FALSE
    public boolean Lab;
    public int NumberOfSeats;

    // Khởi động lại việc gán ID
    public static void restartIDs() { _nextRoomId = 0; }
}
