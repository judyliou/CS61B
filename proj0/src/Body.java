 public class Body{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double g = 6.67e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
                }

    public Body(Body b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        double dis = (xxPos - b.xxPos) * (xxPos - b.xxPos) + (yyPos - b.yyPos) * (yyPos - b.yyPos);
        return Math.sqrt(dis);
    }

    public double calcForceExertedBy(Body b){
        double dis = calcDistance(b);
        return (g * mass * b.mass) / (dis * dis);
    }

    public double calcForceExertedByX(Body b){
        double f = calcForceExertedBy(b);
        double dx = b.xxPos - xxPos;
        double r = calcDistance(b);
        return f * dx / r;
    }

    public double calcForceExertedByY(Body b){
        double f = calcForceExertedBy(b);
        double dy = b.yyPos - yyPos;
        double r = calcDistance(b);
        return f * dy / r;
    }

    public double calcNetForceExertedByX(Body[] bArr){
        double f = 0;
        for (Body b : bArr){
            if (!this.equals(b)){
                f += calcForceExertedByX(b);
            }
        }
        return f;
    }

    public double calcNetForceExertedByY(Body[] bArr){
        double f = 0;
        for (Body b : bArr){
            if (!this.equals(b)){
                f += calcForceExertedByY(b);
            }
        }
        return f;
    }

    public void update(double dt, double Fx, double Fy){
        double ax = Fx / mass;
        double ay = Fy / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "../images/" + imgFileName);
    }
 }