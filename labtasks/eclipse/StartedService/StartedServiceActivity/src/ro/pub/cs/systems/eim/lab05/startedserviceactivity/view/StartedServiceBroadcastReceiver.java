package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    // TODO: exercise 8 - default constructor

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
    	String action = intent.getAction();
    	String data =null;
   
    	
        if (Constants.ACTION_STRING.equals(action)) {
          data = intent.getStringExtra(Constants.DATA);
        }
        
        if (Constants.ACTION_INTEGER.equals(action)) {
            data = String.valueOf(intent.getIntExtra(Constants.DATA,-1));
          }
        
        if (Constants.ACTION_ARRAY_LIST.equals(action)) {
            data = intent.getStringArrayListExtra(Constants.DATA).toString();
          }
   
        if (messageTextView != null) {
          messageTextView.setText(messageTextView.getText().toString() + "\n" + data);
        }
    	
        // TODO: exercise 6 - get the action and the extra information from the intent
        // and set the text on the messageTextView

        // TODO: exercise 8 - restart the activity through an intent
        // if the messageTextView is not available
        Intent startedServiceActivityIntent = new Intent(context,StartedServiceActivity.class);
        startedServiceActivityIntent.putExtra(Constants.MESSAGE, data);
        startedServiceActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(startedServiceActivityIntent);
    }

}
