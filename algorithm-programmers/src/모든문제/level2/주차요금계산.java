package 모든문제.level2;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class 주차요금계산 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] fees = new int[4];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            fees[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int N = Integer.parseInt(bufferedReader.readLine());
        String[] records = new String[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            records[i] = stringTokenizer.nextToken();
        }

        int[] parkingFees = calculateParkingFee(fees, records);
        for (int fee : parkingFees) bufferedWriter.write(fee + " ");
        bufferedWriter.close();
        bufferedReader.close();
    }

    /**
     * @param fees:    [기본 시간, 기본 요금, 단위 시간, 단위 요금]
     * @param records: [시각, 차량번호, 내역]
     * @return
     */
    private static int[] calculateParkingFee(int[] fees, String[] records) {
        Map<String, LocalTime> inTimeRecordsMap = new HashMap<>();
        Map<String, Long> totalParkingTimesMap = new HashMap<>();

        for (String record : records) {
            String[] vehicleRecords = record.split(" ");

            LocalTime eventTime = LocalTime.parse(vehicleRecords[0], DateTimeFormatter.ofPattern("HH:mm"));
            String vehicleNumber = vehicleRecords[1];
            String parkingStatus = vehicleRecords[2];

            if ("IN".equals(parkingStatus)) {
                inTimeRecordsMap.put(vehicleNumber, eventTime);
                continue;
            }

            LocalTime inTime = inTimeRecordsMap.remove(vehicleNumber);
            long difference = Duration.between(inTime, eventTime).toMinutes();
            totalParkingTimesMap.put(vehicleNumber, totalParkingTimesMap.getOrDefault(vehicleNumber, 0L) + difference);
        }

        LocalTime lastTime = LocalTime.of(23, 59);
        for (Map.Entry<String, LocalTime> inTimeEntry : inTimeRecordsMap.entrySet()) {
            String vehicleNumber = inTimeEntry.getKey();
            long difference = Duration.between(inTimeEntry.getValue(), lastTime).toMinutes();
            totalParkingTimesMap.put(vehicleNumber, totalParkingTimesMap.getOrDefault(vehicleNumber, 0L) + difference);
        }

        List<String> sortedVehicles = new ArrayList<>(totalParkingTimesMap.keySet());
        Collections.sort(sortedVehicles);

        int[] parkingFees = new int[sortedVehicles.size()];
        for (int i = 0; i < sortedVehicles.size(); i++) {
            long accumulatedTime = totalParkingTimesMap.get(sortedVehicles.get(i));

            if (accumulatedTime <= fees[0]) {
                parkingFees[i] = fees[1];
                continue;
            }

            long excessTime = accumulatedTime - fees[0];
            double excessAmount = Math.ceil((double) excessTime / fees[2]) * fees[3];
            parkingFees[i] = fees[1] + (int) excessAmount;
        }

        return parkingFees;
    }
}
