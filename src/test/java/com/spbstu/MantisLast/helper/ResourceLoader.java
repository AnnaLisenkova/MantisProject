package com.spbstu.MantisLast.helper;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.spbstu.MantisLast.entities.Task;
import com.spbstu.MantisLast.entities.User;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Map;

/**
 * Created by anna on 02.05.17.
 */
public class ResourceLoader {
    public static final String DATA_USERS_JSON = "data/users.json";
    public static final String DATA_TASKS_JSON = "data/taskFields.json";
    private static Map<String, User> users;
    private static Map<String, Task> tasks;

    static {
        try {
            loadUsers();
            loadIssues();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadUsers() throws IOException {
        String rawData = getRawDataFromUsers(DATA_USERS_JSON);
        Type type = new TypeToken<Map<String, User>>(){}.getType();
        users = new Gson().fromJson(rawData, type);
    }

    private static String getRawDataFromUsers(String dataUsersJson) throws IOException {
        URL resource = ResourceLoader.class.getClassLoader().getResource(DATA_USERS_JSON);
        return IOUtils.toString(resource, "utf-8");
    }

    public static User getUser(String key) {
        return users.get(key);
    }

    private static void loadIssues() throws IOException {
        String rawData = getRawDataFromIssues(DATA_TASKS_JSON);
        Type type = new TypeToken<Map<String, Task>>(){}.getType();
        tasks = new Gson().fromJson(rawData, type);
    }

    private static String getRawDataFromIssues(String dataTasksJson) throws IOException {
        URL resource = ResourceLoader.class.getClassLoader().getResource(DATA_TASKS_JSON);
        return IOUtils.toString(resource, "utf-8");
    }

    public static Task getTask(String key) {
        return tasks.get(key);
    }

}
