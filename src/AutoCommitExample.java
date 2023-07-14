import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class AutoCommitExample {
//    public static void main(String[] args) {
//        try {
//            // WatchService 생성
//            WatchService watchService = FileSystems.getDefault().newWatchService();
//
//            // 감지할 디렉토리 경로 설정
//            Path directory = Paths.get("C:/Users/10/Desktop/algorithm");
//
//            // 디렉토리와 그 하위 디렉토리 모두 감지하기 위해 재귀적으로 등록
//            registerRecursive(directory, watchService);
//
//            System.out.println("자동 커밋을 시작합니다...");
//
//            // 변경 이벤트를 모니터링하는 루프
//            while (true) {
//                WatchKey watchKey = watchService.take();
//
//                for (WatchEvent<?> event : watchKey.pollEvents()) {
//                    WatchEvent.Kind<?> kind = event.kind();
//
//                    // 디렉토리 변경 이벤트일 경우에만 처리
//                    if (kind == StandardWatchEventKinds.ENTRY_MODIFY || kind == StandardWatchEventKinds.ENTRY_CREATE || kind == StandardWatchEventKinds.ENTRY_DELETE) {
//                        // 변경된 디렉토리 경로
//                        Path changedDirectory = ((Path) watchKey.watchable()).resolve((Path) event.context());
//
//                        // 변경된 디렉토리 내의 모든 파일을 순회하며 변경 사항 감지
//                        Files.walkFileTree(changedDirectory, new SimpleFileVisitor<>() {
//                            @Override
//                            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                                // 변경된 파일을 Git으로 커밋하는 작업 수행
//                                commitChangedFile(file);
//                                return FileVisitResult.CONTINUE;
//                            }
//                        });
//                    }
//                }
//
//                // 이벤트 처리가 완료되었음을 알림
//                watchKey.reset();
//            }
//
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void registerRecursive(Path directory, WatchService watchService) throws IOException {
//        Files.walkFileTree(directory, new SimpleFileVisitor<>() {
//            @Override
//            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//                dir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
//                return FileVisitResult.CONTINUE;
//            }
//        });
//    }
//
//
//    private static void commitChangedFile(Path changedFile) {
//        if (changedFile == null) {
//            System.out.println("변경된 파일이 유효하지 않습니다.");
//            return;
//        }
//
//        try {
//            String gitPath = "C:/Program Files/Git/cmd/git.exe";
//            Path directoryPath = changedFile.getParent(); // 수정: String이 아닌 Path로 변경
//
//            // 변경된 파일의 디렉토리로 이동
//            ProcessBuilder processBuilder = new ProcessBuilder(gitPath, "-C", directoryPath.toString(), "add", changedFile.toString());
//            Process process = processBuilder.start();
//            process.waitFor();
//
//            // 변경된 파일이 있는지 확인
//            Process statusProcess = new ProcessBuilder(gitPath, "-C", directoryPath.toString(), "status", "--porcelain").start();
//            BufferedReader statusReader = new BufferedReader(new InputStreamReader(statusProcess.getInputStream()));
//            boolean hasChanges = statusReader.lines().count() > 0;
//
//            if (hasChanges) {
//                // 변경된 파일 추가
//                processBuilder.command(gitPath, "-C", directoryPath.toString(), "add", changedFile.toString());
//                process = processBuilder.start();
//                process.waitFor();
//
//                // 커밋 메시지와 함께 커밋 수행
//                processBuilder.command(gitPath, "-C", directoryPath.toString(), "commit", "-m", "자동 커밋");
//                process = processBuilder.start();
//                process.waitFor();
//
//                // 현재 작업 중인 로컬 브랜치 확인
//                Process branchProcess = new ProcessBuilder(gitPath, "-C", directoryPath.toString(), "rev-parse", "--abbrev-ref", "HEAD").start();
//                BufferedReader branchReader = new BufferedReader(new InputStreamReader(branchProcess.getInputStream()));
//                String currentBranch = branchReader.readLine();
//
//                // 현재 작업 중인 브랜치로 푸시
//                processBuilder.command(gitPath, "-C", directoryPath.toString(), "push", "origin", currentBranch);
//                process = processBuilder.start();
//                process.waitFor();
//
//                System.out.println("자동 커밋이 수행되었습니다.");
//            }
//
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
    // 쓸모 없는 코드들
}