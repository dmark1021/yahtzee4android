package com.tum.yahtzee;

import com.tum.yahtzee.R;
import com.tum.yahtzee.services.MessageService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class YahtzeeActivity extends Activity {
	
	private EditText playerAmountText;
	private EditText roundsText;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        playerAmountText = (EditText)findViewById(R.id.editText_player);
        roundsText = (EditText)findViewById(R.id.editText_rounds);
    }
    
    public void play(View v)
    {
    	String sPlayers = playerAmountText.getText().toString();
    	String sRounds = roundsText.getText().toString();
    	
    	if (sPlayers == null || sPlayers.isEmpty() || Integer.parseInt(sPlayers) == 0 || sRounds == null || sRounds.isEmpty() || Integer.parseInt(sRounds) == 0) {
    		MessageService.showMessage(YahtzeeActivity.this, "Impossible", "Amount of Rounds and Players must not be zero.");
    	} else {
	    	GameController.get().newGame(Integer.parseInt(sPlayers), Integer.parseInt(sRounds));
	    	
	    	Intent intent = new Intent(YahtzeeActivity.this, GameActivity.class);
	    	startActivity(intent);
    	}
	}
}