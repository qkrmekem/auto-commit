import java.io.IOException;
import java.nio.file.*;

public class AutoCommitExample {
    public static void main(String[] args) {
        try {
            // 파일 시스템의 변경 이벤트를 감지하는 WatchService 생성
            WatchService watchService = FileSystems.getDefault().newWatchService();

            // 모니터링할 디렉토리 경로 설정
            Path directory = Paths.get("경로/디렉토리");

            // 디렉토리 변경 이벤트 타입 설정 (여기서는 모든 변경 이벤트를 감지)
            WatchKey watchKey = directory.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

            // 변경 이벤트를 모니터링하는 루프
            while (true) {
                // 변경 이벤트가 발생할 때까지 대기
                watchKey = watchService.take();

                // 변경된 파일들에 대한 이벤트를 처리
                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    // 파일 변경 이벤트일 경우에만 처리
                    if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                        Path changedFile = (Path) event.context();
                        System.out.println("변경된 파일: " + changedFile);

                        // 변경된 파일을 Git으로 커밋 및 푸시하는 작업 수행
                        commitAndPush();
                    }
                }

                // 이벤트 처리가 완료되었음을 알림
                watchKey.reset();
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void commitAndPush() {
        try {
            // 변경된 파일을 Git에 커밋하는 작업 수행
            Runtime.getRuntime().exec("git add .").waitFor();
            Runtime.getRuntime().exec("git commit -m \"자동 커밋\"").waitFor();

            // 커밋된 변경 사항을 푸시하는 작업 수행
            Runtime.getRuntime().exec("git push").waitFor();

            System.out.println("자동 커밋 및 푸시가 완료되었습니다.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}