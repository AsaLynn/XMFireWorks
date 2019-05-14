package com.zxn.wym.fireworks.util;

import android.graphics.PointF;
import com.zxn.wym.fireworks.bean.Firework;
import com.zxn.wym.fireworks.bean.Particle;

import java.util.LinkedList;
import java.util.Queue;

public class BeanUtil {
    public static Queue<Particle> particleQueue = new LinkedList<Particle>();
    public static Queue<Firework> fireworkQueue = new LinkedList<Firework>();
    public static Queue<PointF> pointFQueue = new LinkedList<PointF>();
}
