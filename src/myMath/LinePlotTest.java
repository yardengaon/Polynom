package myMath;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JFrame;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class LinePlotTest extends JFrame {
	public LinePlotTest(Polynom p1 , double x1 , double x2) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 800);
		setLocation(new Point(5,5));
		setVisible(true);
		double x ;

		DataTable data = new DataTable(Double.class, Double.class);
		DataTable data1 = new DataTable(Double.class, Double.class);
		for (x = x1; x <= x2; x+=0.005) {
			if( (-0.01 < p1.derivative().f(x)) && (p1.derivative().f(x) < 0.01) ) {
				double y = p1.f(x);
				x = x+0.005 ;
				data1.add(x, y-0.001);
				x = x+0.005 ;
			}
			else {
				double y = p1.f(x);
				data.add(x, y);
			}
		}     	
		XYPlot plot = new XYPlot(data, data1);
		getContentPane().add(new InteractivePanel(plot));
		LineRenderer lines = new DefaultLineRenderer2D();
		plot.setLineRenderers(data, lines);
		Color color = new Color(0.3f, 0.5f, 1.0f);
		plot.getPointRenderers(data).get(0).setColor(color);
		Color color2 = new Color(0.3f, 0.5f, 1.0f);
		plot.getLineRenderers(data).get(0).setColor(color2);
		Color color1 = new Color(0.9f, 0.1f, 0.6f);
		plot.getPointRenderers(data1).get(0).setColor(color1);	
	}
}
