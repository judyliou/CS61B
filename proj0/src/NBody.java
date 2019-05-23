public class NBody{
    public static double readRadius(String filename){
        In in = new In(filename);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Body[] readbArr(String filename){
        In in = new In(filename);
        int N = in.readInt();
        double R = in.readDouble();

        Body[] bArr = new Body[N];
        for (int i = 0; i < N; i++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            bArr[i] = new Body(xP, yP, xV, yV, m, img);
        }
        return bArr;
    }

    public static void main(String [] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] bArr = readbArr(filename);
        int N = bArr.length;

        // Draw background and planets
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "../images/starfield.jpg");
        for (Body b : bArr){
            b.draw();
        }

        // Prevent flickering in the animation
        StdDraw.enableDoubleBuffering();

        // Time loop
        double time = 0;
        while (time < T){
            double[] xForces = new double[N];
            double[] yForces = new double[N];
            for (int i = 0; i < N; i++){
                xForces[i] = bArr[i].calcNetForceExertedByX(bArr);
                yForces[i] = bArr[i].calcNetForceExertedByY(bArr);
            }
            
            for (int i = 0; i < N; i++){
                bArr[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "../images/starfield.jpg");
            for (Body b : bArr) {
                b.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
			time += dt;
        }

        StdOut.printf("%d\n", bArr.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bArr.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        bArr[i].xxPos, bArr[i].yyPos, bArr[i].xxVel,
                        bArr[i].yyVel, bArr[i].mass, bArr[i].imgFileName);   
}

    }
}