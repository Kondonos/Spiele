import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class sound {
	public static void main(String[] args) throws LineUnavailableException {
		byte[] buf = new byte[ 4];;
	    AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
	    SourceDataLine sdl = AudioSystem.getSourceDataLine( af );
	    sdl.open();
	    sdl.start();
	    for( int i = 0; i < 1000 * (float )44100 / 1000; i++ ) {
	        double angle = i / ( (float )44100 / 440 ) * 2.0 * Math.PI;
	        buf[ 0 ] = (byte )( Math.sin( angle ) * 100 );
	        buf[ 1 ] = (byte )( Math.sin( 2*angle ) *50  );
	        buf[ 2 ] = (byte )( Math.sin( 3*angle ) *25 );
	        buf[ 3 ] = (byte )( Math.sin( 4*angle ) * 12.5 );
	        sdl.write( buf, 0, 1 );
	    }
	    sdl.drain();
	    sdl.stop();
	}
}
