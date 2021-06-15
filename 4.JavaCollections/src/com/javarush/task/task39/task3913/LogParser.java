package com.javarush.task.task39.task3913;

import com.google.common.io.Files;
import com.javarush.task.task39.task3913.query.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir; // директория с логами (логов может быть несколько, все они должны иметь расширение log).
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    private boolean isDateCheck(Date current, Date after, Date before) {
        if (after == null && before == null) {
            return true;
        } else if (after == null) {
            if (current.before(before) || current.equals(before)) return true;
        } else if (before == null) {
            if (current.after(after) || current.equals(after)) return true;
        } else {
            if ((current.equals(after) || current.after(after)) && (current.equals(before) || current.before(before)))
                return true;
        }
        return false;
    }

    private List<String> readLogFilesInDyrectory() { // читаем все строки из всех файлов лог
        List<String> listLinesLogs = new ArrayList<>(); // лист со всеми строками всех файлов логов

        File[] files = logDir.toFile().listFiles((name) -> name.toString().endsWith(".log")); // список файлов в директории

        for (File file : Objects.requireNonNull(files)) {
            try {
                List<String> tempList = Files.readLines(file, StandardCharsets.UTF_8);
                listLinesLogs.addAll(tempList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listLinesLogs;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    //должен возвращать множество, содержащее все не повторяющиеся IP. Тип в котором будем хранить IP будет String
    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> setIPs = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);

                if (isDateCheck(current, after, before)) {
                    setIPs.add(array[0]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //setIPs.forEach(System.out::println);
        return setIPs;
    }

    //должен возвращать IP, с которых работал переданный пользователь.
    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> setIPs = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                String currentUser = array[1];

                if (isDateCheck(current, after, before) && currentUser.equals(user)) {
                    setIPs.add(array[0]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //setIPs.forEach(System.out::println);
        return setIPs;
    }

    //должен возвращать IP, с которых было произведено переданное событие
    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> setIPs = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                Event currentEvent = Event.valueOf(array[3].split(" ")[0]);
                //ip username date event status
                if (isDateCheck(current, after, before) && currentEvent.equals(event)) {
                    setIPs.add(array[0]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //setIPs.forEach(System.out::println);
        return setIPs;
    }

    //должен возвращать IP, события с которых закончилось переданным статусом.
    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> setIPs = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                Status currentStatus = Status.valueOf(array[4]);
                //ip username date event status
                if (isDateCheck(current, after, before) && currentStatus.equals(status)) {
                    setIPs.add(array[0]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return setIPs;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> set = new HashSet<>();
        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            //ip username date event status
            set.add(array[1]);
        }
        return set;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                if (isDateCheck(current, after, before)) {
                    set.add(array[1]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<String> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                if (isDateCheck(current, after, before) && array[1].equals(user)) {
                    String event = array[3].split(" ")[0];
                    set.add(event);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {

        Set<String> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                if (isDateCheck(current, after, before) && array[0].equals(ip)) {
                    set.add(array[1]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String event = Event.LOGIN.name();
                if (isDateCheck(current, after, before) && array[3].split(" ")[0].equals(event)) {
                    set.add(array[1]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String event = Event.DOWNLOAD_PLUGIN.name();
                if (isDateCheck(current, after, before) && array[3].split(" ")[0].equals(event)) {
                    set.add(array[1]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String event = Event.WRITE_MESSAGE.name();
                if (isDateCheck(current, after, before) && array[3].split(" ")[0].equals(event)) {
                    set.add(array[1]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String event = Event.SOLVE_TASK.name();
                if (isDateCheck(current, after, before) && array[3].split(" ")[0].equals(event)) {
                    set.add(array[1]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String event = Event.SOLVE_TASK.name();
                if (array[3].split(" ").length > 1) {

                    int taskNumber = Integer.parseInt(array[3].split(" ")[1]);

                    if (isDateCheck(current, after, before)
                            && array[3].split(" ")[0].equals(event)
                            && taskNumber == task
                    ) {
                        set.add(array[1]);
                    }
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String event = Event.DONE_TASK.name();

                if (isDateCheck(current, after, before) && array[3].split(" ")[0].equals(event)) {
                    set.add(array[1]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String event = Event.DONE_TASK.name();
                if (array[3].split(" ").length > 1) {

                    int taskNumber = Integer.parseInt(array[3].split(" ")[1]);

                    if (isDateCheck(current, after, before)
                            && array[3].split(" ")[0].equals(event)
                            && taskNumber == task
                    ) {
                        set.add(array[1]);
                    }
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {

        Set<Date> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String user1 = array[1];
                Event currentEvent = Event.valueOf(array[3].split(" ")[0]);

                if (isDateCheck(current, after, before)
                        && user1.equals(user)
                        && currentEvent.equals(event)) {
                    set.add(current);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String user1 = array[1];
                Status status = Status.valueOf(array[4]);

                if (isDateCheck(current, after, before)
                        && status.equals(Status.FAILED)) {
                    set.add(current);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> set = new HashSet<>();

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String user1 = array[1];
                Status status = Status.valueOf(array[4]);

                if (isDateCheck(current, after, before)
                        && status.equals(Status.ERROR)) {
                    set.add(current);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        Map<Date, String> map = new TreeMap<>();

        for (String str : readLogFilesInDyrectory()) {
            try {
                String[] array = str.split("\\t");
                Date date = format.parse(array[2]);
                String user1 = array[1];
                //ip username date event status
                Event event = Event.valueOf(array[3].split(" ")[0]);
                Status status = Status.valueOf(array[4]);
                if (isDateCheck(date, after, before)
                        && event.equals(Event.LOGIN)
                        && status.equals(Status.OK)
                        && user1.equals(user)) {
                    map.put(date, str);
                    //System.out.println(str);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //map.forEach((key, value) -> System.out.println(key));
        if (map.size() != 0) {
            return (Date) ((TreeMap) map).firstEntry().getKey();
        } else return null;

    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        Map<Date, String> map = new TreeMap<>();

        for (String str : readLogFilesInDyrectory()) {
            try {
                String[] array = str.split("\\t");
                //ip username date event status
                if (array[3].split(" ").length > 1) {
                    Date date = format.parse(array[2]);
                    String user1 = array[1];
                    Event event = Event.valueOf(array[3].split(" ")[0]);
                    int taskNumber = Integer.parseInt(array[3].split(" ")[1]);
                    if (isDateCheck(date, after, before)
                            && event.equals(Event.SOLVE_TASK)
                            && taskNumber == task
                            && user1.equals(user)) {
                        map.put(date, str);
                        //System.out.println(str);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (map.size() != 0) {
            return (Date) ((TreeMap) map).firstEntry().getKey();
        } else return null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        Map<Date, String> map = new TreeMap<>();

        for (String str : readLogFilesInDyrectory()) {
            try {
                String[] array = str.split("\\t");
                //ip username date event status
                if (array[3].split(" ").length > 1) {
                    Date date = format.parse(array[2]);
                    String user1 = array[1];
                    Event event = Event.valueOf(array[3].split(" ")[0]);
                    int taskNumber = Integer.parseInt(array[3].split(" ")[1]);
                    if (isDateCheck(date, after, before)
                            && event.equals(Event.DONE_TASK)
                            && taskNumber == task
                            && user1.equals(user)) {
                        map.put(date, str);
                        //System.out.println(str);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (map.size() != 0) {
            return (Date) ((TreeMap) map).firstEntry().getKey();
        } else return null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String user1 = array[1];
                Event event = Event.valueOf(array[3].split(" ")[0]);

                if (isDateCheck(current, after, before)
                        && event.equals(Event.WRITE_MESSAGE)
                        && user1.equals(user)
                ) {
                    set.add(current);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String user1 = array[1];
                Event event = Event.valueOf(array[3].split(" ")[0]);

                if (isDateCheck(current, after, before)
                        && event.equals(Event.DOWNLOAD_PLUGIN)
                        && user1.equals(user)
                ) {
                    set.add(current);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String user1 = array[1];
                Event event = Event.valueOf(array[3].split(" ")[0]);

                if (isDateCheck(current, after, before)) {
                    set.add(event);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String user1 = array[1];
                Event event = Event.valueOf(array[3].split(" ")[0]);

                if (isDateCheck(current, after, before)) {
                    set.add(event);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String currentIp = array[0];
                Event event = Event.valueOf(array[3].split(" ")[0]);

                if (isDateCheck(current, after, before)
                        && currentIp.equals(ip)) {
                    set.add(event);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status
                String currentUser = array[1];
                Event event = Event.valueOf(array[3].split(" ")[0]);

                if (isDateCheck(current, after, before)
                        && currentUser.equals(user)) {
                    set.add(event);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status

                Event event = Event.valueOf(array[3].split(" ")[0]);
                Status status = Status.valueOf(array[4]);

                if (isDateCheck(current, after, before)
                        && status.equals(Status.FAILED)) {
                    set.add(event);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

        for (String str : readLogFilesInDyrectory()) {
            String[] array = str.split("\\t");
            try {
                Date current = format.parse(array[2]);
                //ip username date event status

                Event event = Event.valueOf(array[3].split(" ")[0]);
                Status status = Status.valueOf(array[4]);

                if (isDateCheck(current, after, before)
                        && status.equals(Status.ERROR)) {
                    set.add(event);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return set;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return getListUser().stream()
                .filter(log -> log.getEvent() == Event.SOLVE_TASK
                        && log.getTask() == task
                        && (isDateCheck(log.getDate(), after, before)))
                .collect(Collectors.toSet()).size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return getListUser().stream()
                .filter(log -> log.getEvent() == Event.DONE_TASK
                        && log.getTask() == task
                        && (isDateCheck(log.getDate(), after, before)))
                .collect(Collectors.toSet()).size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> result = new HashMap<>();
        getListUser().stream()
                .filter(user -> user.getEvent() == Event.SOLVE_TASK
                        && (isDateCheck(user.getDate(), after, before)))
                .map(user1 -> user1.getTask())
                .forEach(intter -> result.put(intter, result.get(intter) == null ? 1 : result.get(intter) + 1));
        return result;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> result = new HashMap<>();
        getListUser().stream()
                .filter(user -> user.getEvent() == Event.DONE_TASK
                        && (isDateCheck(user.getDate(), after, before)))
                .map(user1 -> user1.getTask())
                .forEach(intter -> result.put(intter, result.get(intter) == null ? 1 : result.get(intter) + 1));
        return result;
    }

    private List<User> getListUser() {
        List<String> stringList = readLogFilesInDyrectory();
        List<User> userList = new ArrayList<>();
        stringList.forEach(str -> userList.add(StringToUser(str)));
        return userList;
    }

    private User StringToUser(String string) {
        User user = null;
        try {
            String[] array = string.split("\\t");
            String ip = array[0];
            String userName = array[1];
            Date date = format.parse(array[2]);
            Event event = Event.valueOf(array[3].split(" ")[0]);
            int task = 0;
            if (array[3].split(" ").length > 1) {
                task = Integer.parseInt(array[3].split(" ")[1]);
            }
            Status status = Status.valueOf(array[4]);
            user = new User(ip, userName, date, event, task, status);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public Set<Object> execute(String query) {
        switch (query) {
            case ("get ip"):
                return new HashSet<>(getUniqueIPs(null, null));
            case ("get user"):
                return new HashSet<>(getAllUsers());
            case ("get date"):
                return new HashSet<>(
                        getListUser().stream().map((user) -> user.getDate()).distinct().collect(Collectors.toList()));
            case ("get event"):
                return new HashSet<>(
                        getListUser().stream().map((user) -> user.getEvent()).distinct().collect(Collectors.toList()));
            case ("get status"):
                return new HashSet<>(
                        getListUser().stream().map((user) -> user.getStatus()).distinct().collect(Collectors.toList()));
        }

        String field1 = getQLMatch(query, "field1"); // ip, user, date, event или status;
        String field2 = getQLMatch(query, "field2"); // ip, user, date, event или status;
        String value = getQLMatch(query, "value1");  // value1 - значение поля field2
        Date after = parserDate(getQLMatch(query, "after"));
        Date before = parserDate(getQLMatch(query, "before"));

        return new HashSet<>(
                getListUser().stream()
                        .filter((user) -> {
                            if (field2.equals("date")) {
                                return isDateCheck2(parserDate(value), after, before);
                            }else {
                                return isDateCheck2(user.getDate(), after, before);
                            }
                        })
                        .filter((user) -> {
                            if (field2.equals("date")) {
                                String s = format.format(getUserField(user, field2));
                                String s1 = format.format(parserDate(value));
                                return s.equals(s1);
                            }
                            return universalGetter(user, field2).equals(value);
                        })
                        .map((user) -> getUserField(user, field1))
                        .distinct()
                        .collect(Collectors.toList()));
    }

    private String getQLMatch(String query, String groupName) {
        String regex = "get (?<field1>\\w+) for (?<field2>\\w+) = \"(?<value1>.*?)\" and date between \"(?<after>.*?)\" and \"(?<before>.*?)\"";
        String regex2 = "get (?<field1>\\w+) for (?<field2>\\w+) = \"(?<value1>.*?)\"";
        String match = null;
        Matcher m = null;
        if (query.contains("between")) {
            m = Pattern.compile(regex).matcher(query);
            m.matches();
            match = m.group(groupName);
        } else {
            if (groupName.equals("after") || groupName.equals("before")) return null;
            m = Pattern.compile(regex2).matcher(query);
            m.matches();
            match = m.group(groupName);
        }
        return match;
    }

    private String universalGetter(User user, String string) {
        switch (string) {
            case ("ip"):
                return user.getIp();
            case ("user"):
                return user.getUserName();
            case ("event"):
                return user.getEvent().toString();
            case ("status"):
                return user.getStatus().toString();

        }
        return null;
    }

    private Object getUserField(User user, String string) {
        switch (string) {
            case ("ip"):
                return user.getIp();
            case ("user"):
                return user.getUserName();
            case ("event"):
                return user.getEvent();
            case ("status"):
                return user.getStatus();
            case ("date"):
                return user.getDate();

        }
        return null;
    }

    private Date parserDate(String string) {
        if (string == null) return null;

        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private boolean isDateCheck2(Date current, Date after, Date before) {
        if (after == null && before == null) {
            return true;
        } else {
            if (current.after(after) && current.before(before))
                return true;
        }
        return false;
    }


}