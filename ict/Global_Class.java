package com.example.ict;

import android.app.Application;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;

import java.util.Random;

public class Global_Class extends Application {

    private Integer know = 0;
    private Integer health = 10;
    private Integer word = 0;
    private Integer full = 10;
    private Integer love = 0;

    private Integer num = 0;  //랜덤 수
    private Integer count = 0;  //카운트
    private Integer score = 0;  //점수
    Integer sum = 0;  //시험 문제 수

    private Integer exam_count = 0; //시험횟수
    private Integer sleep_count = 0;  //수면실 이용 횟수

    private Integer coin = 0;  //코인
    private Integer an = 0;  //안대
    private Integer doll = 0;  //인형
    private Integer mi = 0;  //거울
    private Integer bis = 0; //비스켓

    Integer shop_count = 0; //굿즈샵 방문후 수정관으로 자연스럽게 가기위함

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    //전체 초기화
    public void reset_all(){
        know = 0;
        health = 10;
        word = 0;
        full = 10;
        love = 0;
        num = 0;
        count = 0;
        score = 0;
        exam_count = 0;
        sleep_count = 0;
        coin = 0;
        an = 0;
        doll = 0;
        mi = 0;
        bis = 0;
        shop_count = 0;
        sum = 0;
        for(int i = 0; i < 5; i++) bag[i] = 0;
    }

    //지수
    public Integer getKnow() { return know; }
    public void setKnow(Integer know) { this.know = know; }

    public Integer getHealth() { return health; }
    public void setHealth(Integer health) { this.health = health; }

    public Integer getWord() { return word; }
    public void setWord(Integer word) { this.word = word; }

    public Integer getFull() { return full; }
    public void setFull(Integer full) { this.full = full; }

    public Integer getLove() { return love; }
    public void setLove(Integer love) { this.love = love; }

    public Integer getNum() { return num; }
    public void setNum(Integer num) { this.num = num; }

    public Integer getCount() { return count; }
    public void setCount(Integer count) { this.count = count; }

    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }

    public Integer getExam() { return exam_count; }
    public void setExam() { this.exam_count += 1; }

    public Integer getSleep() { return sleep_count; }
    public void setSleep() { this.sleep_count += 1; }

    public Intent intent_g;

    public Integer kk = 0;

    public long watch = 0;

    public long millisInFuture = 400000;  //1000 = 1초

    public CountDownTimer time_start = new myTimer(millisInFuture, 1000);

    public class myTimer extends CountDownTimer {

        public long millisActual;

        public myTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            millisActual = millisInFuture;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if (millisUntilFinished <= millisActual) {
                watch = millisUntilFinished / 1000;
            }
        }

        @Override
        public void onFinish() {
            Handler mHandler2 = new Handler();
            mHandler2.postDelayed(new Runnable() {
                public void run() {
                    if(kk == 1) ((NextActivitySsb)NextActivitySsb.ssb_Context).start_ssb();
                    else if(kk == 2) ((NextActivitySjb)NextActivitySjb.sjb_Context).start_sjb();
                    else if(kk == 3) ((RotcGame)RotcGame.rotc_Context).start_rotc();
                    else if(kk == 4) ((NextActivityShop)NextActivityShop.shop_Context).start_shop();
                    else if(kk == 5) ((NextActivityNanhyang)NextActivityNanhyang.nan_Context).start_nan();
                    else if(kk == 6) ((NextActivityLibrary)NextActivityLibrary.lib_Context).start_lib();
                    else if(kk == 7) ((NextActivityLawn)NextActivityLawn.lawn_Context).start_lawn();
                    else if(kk == 8) ((NextActivityHill)NextActivityHill.hill_Context).start_hill();
                    else if(kk == 9) ((NextActivityGym)NextActivityGym.gym_Context).start_gym();
                    else ((Map_SungShin)Map_SungShin.map_Context).start_map();
                }
            }, 100);
        }
    }

    //가방
    public Integer getCoin() { return coin; }
    public void setCoin(Integer coin) {
        this.coin = coin;
        if(this.coin == 0)
            for(int i = 0; i < 5; i++)
                if(bag[i] == 100) {
                    sort(i);
                    break;
                }
    }

    public Integer getAn() { return an; }
    public void setAn(Integer an) {
        this.an = an;
        if(this.an == 0)
            for(int i = 0; i < 5; i++)
                if(bag[i] == 101) {
                    sort(i);
                    break;
                }
    }

    public Integer getDoll() { return doll; }
    public void setDoll(Integer doll) {
        this.doll = doll;
        if(this.doll == 0)
            for(int i = 0; i < 5; i++)
                if(bag[i] == 102) {
                    sort(i);
                    break;
                }
    }

    public Integer getMi() { return mi; }
    public void setMi(Integer mi) {
        this.mi = mi;
        if(this.mi == 0)
            for(int i = 0; i < 5; i++)
                if(bag[i] == 103) {
                    sort(i);
                    break;
                }
    }

    public Integer getBis() { return bis; }
    public void setBis(Integer bis) {
        this.bis = bis;
        if(this.bis == 0)
            for(int i = 0; i < 5; i++)
                if(bag[i] == 104) {
                    sort(i);
                    break;
                }
    }

    public Integer[] bag = {0, 0, 0, 0, 0}; // 코인 = 100, 안대 = 101, 인형 = 102, 거울 = 103, 비스킷 = 104

    public void setBag(int name){
        for(int i = 0; i < 5; i++){
            if(bag[i] == name) break;
            if(bag[i] == 0) {
                bag[i] = name;
                break;
            }
        }
    }

    public void sort(int num){
        if (4 - num >= 0) System.arraycopy(bag, num + 1, bag, num, 4 - num);
    }

    //랜덤 정보(밤샘)
    public String getRandomBam() {
        Random random = new Random();
        int num = random.nextInt(10);

        if(num == 0) return "성신관에 수하루가 있습니다.";
        else if(num == 1) return "언덕을 지나다보면 귀여운 생물을 만날지도 모릅니다.";
        else if(num == 2) return "수정관의 수면실에선 폰을 할 수 없습니다.";
        else if(num == 3) return "학생회관으로 가면 언덕을 오르지 않아도 됩니다.";
        else if(num == 4) return "도서관에서 밤을 샐 수 있습니다.";
        else if(num == 5) return "수정관의 굿즈샵엔 다양한 학교 굿즈를 팔고 있습니다.";
        else if(num == 6) return "성신관에 재학, 재직 증명서를 뽑을 수 있는 무인 기기가 있습니다.";
        else if(num == 7) return "성신여대 언덕은 3단 언덕 입니다.";
        else if(num == 8) return "난향관에서 먹는 학식은 굳이 나가서 사먹을 필요가 없는 맛입니다.";
        else return "수정관에서 우체국 물품을 받을 수 있습니다.";
    }

    //랜덤 팁(대자보)
    public String getRandomTip() {
        Random random = new Random();
        int num = random.nextInt(10);

        if(num == 0) return "성신관에서 개인 능력치를 볼 수 있습니다.";
        else if(num == 1) return "어디로 갈지 못 정했다면 성신관에 가보세요.";
        else if(num == 2) return "굿즈를 사면 학교에 대한 애정이 늘어날까요?";
        else if(num == 3) return "모든 거래는 성신코인으로 합니다.";
        else if(num == 4) return "고양이의 이름을 알려면 생김새를 보세요";
        else if(num == 5) return "여기 나오는 고양이는 실제 고양이입니다.";
        else if(num == 6) return "시험을 잘보고 싶다면 밤샘을 하세요";
        else if(num == 7) return "가끔은 내 체력과 배고픔을 확인할 필요가 있습니다.";
        else if(num == 8) return "학식 메뉴는 실제 학식사진입니다.";
        else return "여러개의 엔딩을 모아보세요!";
    }

    //랜덤 문구(글로벌 라운지)
    public String getRandomEng() {
        Random random = new Random();
        int num = random.nextInt(5);

        if(num == 0) return "BRIGHT SUNGSHIN";
        else if(num == 1) return "ADD YOU TO TODAY'S SUNGSHIN, TOMORROW'S CRYSTAL BRIGHTER";
        else if(num == 2) return "BECAUSE OF SUNGSHIN, NATURALLY SUNGSHIN";
        else if(num == 3) return "CRYSTAL BALL IS NOT PURPLE";
        else if(num == 4) return "SUNGSHIN IS MY TODAY, I AM SUNGSHIN'S TOMORROW";
        else return "FUN SCHOOL LIFE WITH SURYONGI";
    }

    //문제 은행
    public String getRandomTQuiz(int num) {

        Random random2 = new Random();         //'맞았다'의 랜덤 문제
        int num2 = random2.nextInt(10);

        Random random3 = new Random();         //'틀렸다'의 랜덤 문제
        int num3 = random3.nextInt(10);

        if (num == 0) {
            if (num2 == 0) return "성신관에 수하루가 있습니다.";
            else if (num2 == 1) return "언덕을 지나다보면 귀여운 생물을 만날지도 모릅니다.";
            else if (num2 == 2) return "수정관의 수면실에선 폰을 할 수 없습니다.";
            else if (num2 == 3) return "학생회관으로 가면 언덕을 오르지 않아도 됩니다.";
            else if (num2 == 4) return "도서관에서 밤을 샐 수 있습니다.";
            else if (num2 == 5) return "수정관의 굿즈샵엔 다양한 학교 굿즈를 팔고 있습니다.";
            else if (num2 == 6) return "성신관에 재학, 재직 증명서를 뽑을 수 있는 무인 기기가 있습니다.";
            else if (num2 == 7) return "성신여대 언덕은 3단 언덕 입니다.";
            else if (num2 == 8) return "난향관에서 먹는 학식은 굳이 나가서 사먹을 필요가 없는 맛입니다.";
            else return "수정관에서 우체국 물품을 받을 수 있습니다.";
        }
        else {
            if (num3 == 0) return "수정관에 수하루가 있습니다.";
            else if (num3 == 1) return "성신관에서 학식을 먹을 수 있습니다.";
            else if (num3 == 2) return "언덕의 수면실에선 폰을 할 수 없습니다.";
            else if (num3 == 3) return "정문으로 가면 언덕을 오르지 않아도 됩니다.";
            else if (num3 == 4) return "언덕에서 밤을 샐 수 있습니다.";
            else if (num3 == 5) return "학생회관의 굿즈샵엔 다양한 학교 굿즈를 팔고 있습니다.";
            else if (num3 == 6) return "성신관에 라면을 뽑을 수 있는 무인 기기가 있습니다.";
            else if (num3 == 7) return "성신여대 언덕은 5단 언덕 입니다.";
            else if (num3 == 8) return "체육관에 있는 학식은 굳이 나가서 사먹을 필요가 없는 맛입니다.";
            else return "난향관에서 우체국 물품을 받을 수 있습니다.";
        }
    }
}