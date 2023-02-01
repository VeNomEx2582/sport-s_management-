package com.example.playerinfovtp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class HomeAcivity extends AppCompatActivity {

    ImageView btMenu;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    MainAdapter adapter;
    RecyclerView rcv;
    myadapterr adapterr;

    CardView cdadd,cdshow,cddetele,cdupdate;

    public static ArrayList<String> arrayList = new ArrayList<>();

    public static void closerDrawer(DrawerLayout drawerLayout) {
        //Check condition
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acivity);

        setTitle("Recycler and Card View Demo");

        rcv = (RecyclerView) findViewById(R.id.recview);
        //  rcv.setLayoutManager(new LinearLayoutManager(this));

        adapterr = new myadapterr(dataqueue(),getApplicationContext());
        rcv.setAdapter(adapterr);

        //LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //rcv.setLayoutManager(layoutManager);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        rcv.setLayoutManager(gridLayoutManager);

        drawerLayout = findViewById(R.id.drawer_layout);
        btMenu = findViewById(R.id.bt_menu);
        recyclerView =findViewById(R.id.recycler_view);

        arrayList.clear();

        //Add menu item in array list
        arrayList.add("🏚 Home");
        arrayList.add("🧍 Player");
        arrayList.add("📉 Court Diagram");
        arrayList.add("⚠ About");
        arrayList.add("➡ Exit");

        //Initialize adapter
        adapter = new MainAdapter(this,arrayList);
        //Set layout  manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Set adapter
        recyclerView.setAdapter(adapter);

        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open drawer
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


//        cdadd = findViewById(R.id.add);
//        cdshow = findViewById(R.id.show);
//        cddetele = findViewById(R.id.delete);
//        cdupdate = findViewById(R.id.update);
//
//        cdadd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i = new Intent(getApplicationContext(), AddPlayer.class);
//                startActivity(i);
//            }
//        });
//        cdshow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i = new Intent(getApplicationContext(), ShowPlayer.class);
//                startActivity(i);
//            }
//        });
//        cddetele.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i = new Intent(getApplicationContext(), DeletePlayer.class);
//                startActivity(i);
//            }
//        });
//        cdupdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent i = new Intent(getApplicationContext(), UpdatePlayer.class);
//                startActivity(i);
//            }
//        });

    }
    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closerDrawer(drawerLayout);

    }

    public ArrayList<Model> dataqueue()
    {
        ArrayList<Model> holder=new ArrayList<>();

        Model ob1=new Model();
        ob1.setHeader("kabaddi");
        ob1.setDesc("India");
//        ob1.setCourtimg(R.drawable.kabaddibac);
        ob1.setImgname(R.drawable.k1);
        ob1.setTv3("length : 13m \nWidth : 10m \ncenter line : 6.5m \nlobby : 1m \nBaulk line : 3.75m(frome center line) \nBonus line : 1m(frome baulk line) \nEndline : 1.75m(frome bonus line)  ");
        ob1.setTv4("length : 12m \nWidth : 8m \ncenter line : 6m \nlobby : 1m \nBaulk line : 3m(frome center line) \nBonus line : 1m(frome baulk line) \nEndline : 2m(frome bonus line)" );
        ob1.setTv5("The basic rules of Kabaddi are simple: two teams of seven players each face off in a large square arena for two halves of twenty minutes each. Players from each team take turns running across the center line to the other team's half of the court, tagging members of the other team, and running back. \nSome touches that are legal in kabaddi are; \nFoot touch. \n" +
                "Toe touch.\n" +
                "Thrust.\n" +
                "Squat leg.\n" +
                "Kicks.\n" +
                "Touching of hand through upper limbs.");
        holder.add(ob1);

        Model ob2=new Model();
        ob2.setHeader("Cricket");
        ob2.setDesc("England");
        ob2.setImgname(R.drawable.k15);
        ob2.setTv3(" The pitch is a rectangular area of the ground \n22 yards/20.12 m in length and  \n10 ft/3.05 m in width.");
        ob2.setTv4(" The cricket field has smaller dimensions;\nthe boundaries must be between 55 and 70 yards (50.29 and 64.01 m), \nin contrast to the 65 to 90 yards (59.44 to 82.30 m)\nrequired in men's Tests.");
        ob2.setTv5("If you want to be a great batsman, here are some very helpful cricket batting tips for you:\n" +
                "Standing Sideways. Always stand facing the bowler with your feet shoulder-width apart. ...\n" +
                "Hold the bat. ...\n" +
                "Distance between bat and stump. ...\n" +
                "Tap the bat on the ground line. ...\n" +
                "Swing Backward Momentum. ...\n" +
                "Eyes on the ball. ...\n" +
                "Swing the bat downward. ");
        holder.add(ob2);

        Model ob3=new Model();
        ob3.setHeader("Badminton");
        ob3.setDesc("India");
        ob3.setImgname(R.drawable.k3);
        ob3.setTv3("The badminton court is 13.4m long and \n6.1m wide.\nFor singles the court is marked 5.18m wide.\nThe lines marking out the court are easily distinguishable and coloured white or yellow.\nThe lines are 40mm wide.");
        ob3.setTv4("The badminton court is 13.4m long and 6.1m wide.\nFor singles the court is marked 5.18m wide. \nThe lines marking out the court are easily distinguishable and coloured white or yellow. \nThe lines are 40mm wide.");
        ob3.setTv5("What is the most important skill in badminton?\n" +
                "In badminton, the forehand clear is the first and most essential skill for novices to learn. Most beginners will start learning badminton by going through rallies - continuously hitting the shuttlecock high up in the air back and forth for as long as possible. "+
                "What are the 7 techniques in playing badminton?\n" +
                "Image result for badminton techniques\n" +
                "Grip.\n" +
                "Stance.\n" +
                "Footwork.\n" +
                "Serve.\n" +
                "Smash.\n" +
                "Drop Shot.\n" +
                "Clear or Lob.");
        holder.add(ob3);

        Model ob4=new Model();
        ob4.setHeader("Kho-Kho");
        ob4.setDesc("India");
        ob4.setImgname(R.drawable.k4);
        ob4.setTv3("It is 27 by 16 metres (89 ft × 52 ft) in length nio. \nIn the middle of these two rectangles, \nthere are two wooden poles. \nThe central lane's dimensions are 24 m × 30cm.");
        ob4.setTv4("It is 27 by 16 metres (89 ft × 52 ft) in length nio. \nIn the middle of these two rectangles, \nthere are two wooden poles. \nThe central lane's dimensions are 24 m × 30 cm. There are eight cross lanes which lie across the central lane, \nwhose dimensions are 16 m × 35 cm.");
        ob4.setTv5("TO GIVE KHO To give KHO an attacker should touch the chaser from behind him/her and then utter the word KHO loudly and distinctly. Note: If the action of uttering the word KHO precedes the action of touching by hand, then it shall be deemed as Foul.Simultaneous action of touching and uttering KHO is not a Foul. ");
        holder.add(ob4);

        Model ob5=new Model();
        ob5.setHeader("Table Tennis");
        ob5.setDesc("England");
        ob5.setImgname(R.drawable.k5);
        ob5.setTv3("The table is rectangular, 9 by 5 feet (2.7 by 1.5 metres), \nits upper surface a level plane 30 inches (76 cm) above the floor. \nThe net is 6 feet (1.8 metres) long, \nand its upper edge along the whole length is 6 inches (15.25 cm) above the playing surface.");
        ob5.setTv4("The table is 2.74 m (9.0 ft) long, \n1.525 m (5.0 ft) wide, and 76 cm (2.5 ft) \nhigh with any continuous material so long as the table yields a uniform bounce of \nabout 23 cm (9.1 in) when a standard ball is dropped onto it from a height of 30 cm (11.8 in), \nor about 77%.");
        ob5.setTv5("What is the most important skill in table tennis?\n" +
                "The most crucial table tennis ability is being able to consistently strike the ball. The remainder of the game is simple after you learn to manage the ping pong ball and keep it on the table. "+
                "Know what spin is on the ball. ...\n" +
                "Compensate for the spin with your racket angle. ...\n" +
                "Use your whole body when you stroke your forehand. ...\n" +
                "Maintain a good ready position. ...\n" +
                "Train your strokes until they are automatic. ...\n" +
                "Use your own table tennis racket. ...\n" +
                "Develop sidespin serves.");
        holder.add(ob5);

        Model ob6=new Model();
        ob6.setHeader("Judo");
        ob6.setDesc("Japan");
        ob6.setImgname(R.drawable.k6);
        ob6.setTv3("The competition area is a minimum of \n14m x 14m and is divided into two zones.\nThe inner zone called the contest area is a minimum of \n8m x 8m to a maximum of 10m x 10m. \nThe outer zone is the safety area and is a minimum of 3m wide.");
        ob6.setTv4("The competition area is a minimum of \n14m x 14m and is divided into two zones.\nThe inner zone called the contest area is a minimum of \n8m x 8m to a maximum of 10m x 10m. \nThe outer zone is the safety area and is a minimum of 3m wide.");
        ob6.setTv5("They are categorized into throwing techniques (nage-waza), grappling techniques (katame-waza), body-striking techniques (atemi-waza), blocks and parries (uke-waza), receiving/breakfall techniques (ukemi), and resuscitation techniques (kappo).");
        holder.add(ob6);

        Model ob7=new Model();
        ob7.setHeader("karate");
        ob7.setDesc("Japan");
        ob7.setImgname(R.drawable.k12);
        ob7.setTv3("The competition area is a matted square with a length of 8 meters on each side. \nThe area may be raised up to 1 metre above the floor. \nIf elevated it should measure 12 meters each side, \nwhile the outer 2 meters being the safety area.");
        ob7.setTv4("Karate Competition Areas have a competition length and \nwidth of 26.25' (8 m) for a contest area of \n689 ft² (64 m²)");
        ob7.setTv5(" The fundamentals of Karate are arranged around the four main Kihon: stances (Tachikata), punches (Tsuki), blocks (Uke), and kicks (Geri). Mastery of these basics is necessary to excel as a karateka.");
        holder.add(ob7);

        Model ob8=new Model();
        ob8.setHeader("Taekwondo");
        ob8.setDesc("Korea");
        ob8.setImgname(R.drawable.k14);
        ob8.setTv3("The contest area is a 8m x 8m square and a safety area of 2m to 4m. The total size of the competition area which includes the contest area and safety area is 10m x 10m to a maximum of 12m x 12m.");
        ob8.setTv4("The contest area is a 8m x 8m square and a safety area of 2m to 4m. The total size of the competition area which includes the contest area and safety area is 10m x 10m to a maximum of 12m x 12m.");
        ob8.setTv5("Taekwondo Techniques\n" +
                "Attention Stance. Cha ryuht sohgi is a stance in which the arms are slightly bent at one's sides and hands are in fists (with only thumbs touching the legs). ...\n" +
                "Closed Stance. Moa Sohgi means feet together.\n" +
                "Ready Stance. ...\n" +
                "Short Stance. ...\n" +
                "Long Stance. ...\n" +
                "Tiger Stance. ...\n" +
                "Sitting/Riding Stance. ...\n" +
                "Fighting Stance. ");
        holder.add(ob8);

        Model ob9=new Model();
        ob9.setHeader("Wrestling");
        ob9.setDesc("Ancient Egypt");
        ob9.setImgname(R.drawable.k13);
        ob9.setTv3("The inside part of the mat inside the red circle is the central wrestling area. It is 7m in diameter. The protection area is 1.5m wide. Surrounding the central circle is a band 10cm wide.");
        ob9.setTv4("A standard wrestling mat must have a total square surface  of 12 m x 12 m or octagonal with a diameter of 12 m.\nA circle of 1 m diameter surrounded by a 10cm width band must be drawn in the middle of the mat.");
        ob9.setTv5("Wrestling Moves\n" +
                "Freestyle: Importance Of Drilling Basics To High Scoring Positions. ...\n" +
                "Freestyle: Double Leg Change Angle. ...\n" +
                "Freestyle: Double Leg Lift Bring Back To Back. ...\n" +
                "Freestyle: Double Leg Lift Standing Foot Hook. ...\n" +
                "Freestyle: Double Leg Drive Up To Bear Hug. ...\n" +
                "Freestyle: Double Leg Opponent Counters Around Waist Elbow Capture. ");
        holder.add(ob9);

        Model ob10=new Model();
        ob10.setHeader("Power Lifting");
        ob10.setDesc("ancient Greece");
        ob10.setImgname(R.drawable.k11);
        ob10.setTv3("Your standard pre-made deadlift platforms is  typically four feet tall by eight feet wide.  This isn’t a regulation size, but for the average gym, you’ll usually see these platforms with a 4-6 foot length and an eight foot width. If you buy pre-made platforms from Rogue, York, or other top sellers, then these dimensions are what you can expect.");
        ob10.setTv4("Your standard pre-made deadlift platforms is  typically four feet tall by eight feet wide.  This isn’t a regulation size, but for the average gym, you’ll usually see these platforms with a 4-6 foot length and an eight foot width. If you buy pre-made platforms from Rogue, York, or other top sellers, then these dimensions are what you can expect.");
        ob10.setTv5("What are the 3 movements in powerlifting?\n" +
                "Image result for powerlifting techniques\n" +
                "Powerlifting is a strength sport that consists of three attempts at maximal weight on three lifts: squat, bench press, and deadlift. ");
        holder.add(ob10);

        Model ob11=new Model();
        ob11.setHeader("Boxing");
        ob11.setDesc("India");
        ob11.setImgname(R.drawable.k9);
        ob11.setTv3("Generally bouts take place in a “ring” that is 18 to 22 feet (5.5 to 6.7 metres) square and surrounded by four strands of rope. Professional bouts may be scheduled to last from 4 to 12 rounds of three minutes' duration, though two-minute rounds are commonly used in women's bouts and in some bouts held in Great Britain.");
        ob11.setTv4("Generally bouts take place in a “ring” that is 18 to 22 feet (5.5 to 6.7 metres) square and surrounded by four strands of rope. Professional bouts may be scheduled to last from 4 to 12 rounds of three minutes' duration, though two-minute rounds are commonly used in women's bouts and in some bouts held in Great Britain.");
        ob11.setTv5("There are four main punches in boxing:\n" +
                "Jab - a sudden punch.\n" +
                "Cross - a straight punch.\n" +
                "Hook - a short side power punch.\n" +
                "Uppercut - a short swinging upward power punch.");
        holder.add(ob11);

        Model ob12=new Model();
        ob12.setHeader("Weight Lifting");
        ob12.setDesc("Germany");
        ob12.setImgname(R.drawable.k10);
        ob12.setTv3("The field of play consists of the platform as well as the surrounding floor. Like the platform, it is also square shaped having dimensions 10 metres by 10 metres. A maximum height of 10 metres is allowed, when measured from the level where the Jury and the Referees are positioned. During the time of placing the platform on the stage, each must be affixed to the stage at a minimum distance of 2.5 metres from the front edge and 2 metres from the back edge of the platform. The restraining bars should have maximum height and width of 200mm. ");
        ob12.setTv4("The field of play consists of the platform as well as the surrounding floor. Like the platform, it is also square shaped having dimensions 10 metres by 10 metres. A maximum height of 10 metres is allowed, when measured from the level where the Jury and the Referees are positioned. During the time of placing the platform on the stage, each must be affixed to the stage at a minimum distance of 2.5 metres from the front edge and 2 metres from the back edge of the platform. The restraining bars should have maximum height and width of 200mm. ");
        ob12.setTv5(" Weight training do's\n" +
                "Lift an appropriate amount of weight. Start with a weight you can lift comfortably 12 to 15 times. ...\n" +
                "Use proper form. Learn to do each exercise correctly. ...\n" +
                "Breathe. You might be tempted to hold your breath while you're lifting weights. ...\n" +
                "Seek balance. ...\n" +
                "Add strength training in your fitness routine. ...\n" +
                "Rest. ");
        holder.add(ob12);

        Model ob13=new Model();
        ob13.setHeader("Volley Ball");
        ob13.setDesc("Massachusetts");
        ob13.setImgname(R.drawable.k7);
        ob13.setTv3("Dimensions. The playing court is 18m long and 9m wide and is surrounded by a free zone 3m wide on all sides. The space above the playing area is known as the free playing space and is a minimum of 7m high from the playing surface.");
        ob13.setTv4("The volleyball court size in meters is 18 m by 9 m. A free zone on all sides must surround this playing court, which must be at least 3 m wide. The volleyball court size in feet is 59 feet by 29 feet 6 inches. ");
        ob13.setTv5("The volleyball techniques - serving, passing, setting, hitting, blocking, and digging - are the six major volleyball skills players must develop.\n" +
                "...\n" +
                "Attacking at the Net\n" +
                "Approaching quick. ...\n" +
                "Swing your arms back. ...\n" +
                "Bring both your arms up. ...\n" +
                "Contact the ball in front of your hitting shoulder. ...\n" +
                "Put top-spin on the ball. ");
        holder.add(ob13);

        Model ob14=new Model();
        ob14.setHeader("Athletics");
        ob14.setDesc("Western Europe and North America");
        ob14.setImgname(R.drawable.k16);
        ob14.setTv3("The Track comprises 2 semicircles, each with a radius of 36.50m, which are joined by two straights, each 84.39m in length. The Track has 8, 6 or occasionally 4 lanes but the last is not used for international running competition. All lanes have a width of 1.22m ± 0.01m.");
        ob14.setTv4("The Track comprises 2 semicircles, each with a radius of 36.50m, which are joined by two straights, each 84.39m in length. The Track has 8, 6 or occasionally 4 lanes but the last is not used for international running competition. All lanes have a width of 1.22m ± 0.01m. ");
        ob14.setTv5("Athletics Technique\n" +
                "Focus on being tall.\n" +
                "Stay relaxed.\n" +
                "Focus on being light on your feet.\n" +
                "When sprinting, use your arms strongly.\n" +
                "Keep your head and shoulders facing straight ahead. ");
        holder.add(ob14);

        return holder;
    }
}