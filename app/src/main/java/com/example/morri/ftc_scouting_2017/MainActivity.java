package com.example.morri.ftc_scouting_2017;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinnerDT = (Spinner) findViewById(R.id.driveTeamSpinner);
        ArrayAdapter<CharSequence> DTadapt = ArrayAdapter.createFromResource(this, R.array.DTR, android.R.layout.simple_spinner_item);
        DTadapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDT.setAdapter(DTadapt);

        Spinner spinnerTeams = (Spinner) findViewById(R.id.teamNumberSpinner);
        ArrayAdapter<CharSequence> TeamsAdapt = ArrayAdapter.createFromResource(this, R.array.Teams, android.R.layout.simple_spinner_item);
        TeamsAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTeams.setAdapter(TeamsAdapt);

        Switch allianceSwitch = (Switch) findViewById(R.id.allianceColor);

        EditText numAutoSkystones = (EditText) findViewById(R.id.numAutoSkystones);
        EditText numAutoStones = (EditText) findViewById(R.id.numAutoStones);
        EditText numAutoPlaced = (EditText) findViewById(R.id.numAutoPlaced);
        EditText numTeleDelivered = (EditText) findViewById(R.id.numTeleDelivered);
        EditText numTelePlaced = (EditText) findViewById(R.id.numTelePlaced);
        EditText numTeleTallSky = (EditText) findViewById(R.id.numTeleTallSky);
        EditText scoutName = (EditText) findViewById(R.id.scoutName);
        EditText matchNum = (EditText) findViewById(R.id.matchNumber);

        CheckBox autoParking = (CheckBox) findViewById(R.id.checkBox_autoParking);
        CheckBox autoRepositioning = (CheckBox) findViewById(R.id.checkBox_autoRepositioning);
        CheckBox endCapping = (CheckBox) findViewById(R.id.checkBox_endCapping);
        CheckBox endFoundation = (CheckBox) findViewById(R.id.checkBox_endFoundation);
        CheckBox endParking = (CheckBox) findViewById(R.id.checkBox_endParking);

        Button submitButton = (Button) findViewById(R.id.submitButton);
        Button DASSButton = (Button) findViewById(R.id.buttonDownAutoSkystones);
        Button UASSButton = (Button) findViewById(R.id.buttonUpAutoSkystones);
        Button DASButton = (Button) findViewById(R.id.buttonDownAutoStones);
        Button UASButton = (Button) findViewById(R.id.buttonUpAutoStones);
        Button DAPButton = (Button) findViewById(R.id.buttonDownAutoPlaced);
        Button UAPButton = (Button) findViewById(R.id.buttonUpAutoPlaced);

        Button DTDButton = (Button) findViewById(R.id.buttonDownTeleDelivered);
        Button UTDButton = (Button) findViewById(R.id.buttonUpTeleDelivered);
        Button DTPButton = (Button) findViewById(R.id.buttonDownTelePlaced);
        Button UTPButton = (Button) findViewById(R.id.buttonUpTelePlaced);
        Button DTTSButton = (Button) findViewById(R.id.buttonDownTeleTallSky);
        Button UTTSButton = (Button) findViewById(R.id.buttonUpTeleTallSky);

        EditText newTeamNum = (EditText) findViewById(R.id.addedTeamNo);

        DASSButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numAutoSkystones.getText().toString());
            if(start > 0) {
                start--;
                String result = String.valueOf(start);
                numAutoSkystones.setText(result);
            }
        });
        UASSButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numAutoSkystones.getText().toString());
            start++;
            String result = String.valueOf(start);
            numAutoSkystones.setText(result);
        });

        DASButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numAutoStones.getText().toString());
            if(start > 0) {
                start--;
                String result = String.valueOf(start);
                numAutoStones.setText(result);
            }
        });
        UASButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numAutoStones.getText().toString());
            start++;
            String result = String.valueOf(start);
            numAutoStones.setText(result);
        });

        DAPButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numAutoPlaced.getText().toString());
            if(start > 0) {
                start--;
                String result = String.valueOf(start);
                numAutoPlaced.setText(result);
            }
        });
        UAPButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numAutoPlaced.getText().toString());
            start++;
            String result = String.valueOf(start);
            numAutoPlaced.setText(result);
        });

        DTDButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numTeleDelivered.getText().toString());
            if(start > 0) {
                start--;
                String result = String.valueOf(start);
                numTeleDelivered.setText(result);
            }
        });
        UTDButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numTeleDelivered.getText().toString());
            start++;
            String result = String.valueOf(start);
            numTeleDelivered.setText(result);
        });

        DTPButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numTelePlaced.getText().toString());
            if(start > 0) {
                start--;
                String result = String.valueOf(start);
                numTelePlaced.setText(result);
            }
        });
        UTPButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numTelePlaced.getText().toString());
            start++;
            String result = String.valueOf(start);
            numTelePlaced.setText(result);
        });

        DTTSButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numTeleTallSky.getText().toString());
            if(start > 0) {
                start--;
                String result = String.valueOf(start);
                numTeleTallSky.setText(result);
            }
        });
        UTTSButton.setOnClickListener(v -> {
            int start = Integer.parseInt(numTeleTallSky.getText().toString());
            start++;
            String result = String.valueOf(start);
            numTeleTallSky.setText(result);
        });

        submitButton.setOnClickListener(v -> {
            if (scoutName.getText().toString().equals("")) {
                Snackbar.make(findViewById(R.id.myConstraintLayout), "Please enter Scout Name", Snackbar.LENGTH_SHORT).show();
            } else if (spinnerTeams.getSelectedItem().equals("")) {
                Snackbar.make(findViewById(R.id.myConstraintLayout), "Please enter Team Number", Snackbar.LENGTH_SHORT).show();
            } else if (matchNum.getText().toString().equals("")) {
                Snackbar.make(findViewById(R.id.myConstraintLayout), "Please enter Match Number", Snackbar.LENGTH_SHORT).show();
            } else {
                JSONObject output = new JSONObject();
                try {
                    output.put("name", scoutName.getText());

                    if(spinnerTeams.getSelectedItem().toString().equals("Add New Team")) {
                        output.put("team_number", newTeamNum.getText());
                    } else {
                        output.put("team_number", spinnerTeams.getSelectedItem().toString());
                    }
                    int outAutoReposition = autoRepositioning.isChecked()? 1 : 0;
                    int outAutoParking = autoParking.isChecked()? 1 : 0;
                    int outEndCapping = endCapping.isChecked()? 1 : 0;
                    int outEndFoundation = endFoundation.isChecked()? 1 : 0;
                    int outEndParking = endParking.isChecked()? 1 : 0;

                    output.put("match_number", matchNum.getText());
                    output.put("auto_skystones", Integer.parseInt(numAutoSkystones.getText().toString()));
                    output.put("auto_stones", Integer.parseInt(numAutoStones.getText().toString()));
                    output.put("auto_placed", Integer.parseInt(numAutoPlaced.getText().toString()));
                    output.put("auto_reposition", outAutoReposition);
                    output.put("auto_parking", outAutoParking);
                    output.put("tele_delivered", Integer.parseInt(numTeleDelivered.getText().toString()));
                    output.put("tele_placed", Integer.parseInt(numTelePlaced.getText().toString()));
                    output.put("tele_tallestSS", Integer.parseInt(numTeleTallSky.getText().toString()));
                    output.put("end_capping", outEndCapping);
                    output.put("end_foundation", outEndFoundation);
                    output.put("end_parking", outEndParking);
                    output.put("drive_team", Integer.parseInt(spinnerDT.getSelectedItem().toString()));
                    Log.d("output", output.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // Write JSON to file
                String outStr = "";
                if(spinnerTeams.getSelectedItem().toString().equals("Add New Team")) {
                    outStr = matchNum.getText() + "-" + newTeamNum.getText() + ".json";
                } else {
                    outStr = matchNum.getText() + "-" + spinnerTeams.getSelectedItem().toString() + ".json";
                }



                File dir = new File(Environment.getExternalStorageDirectory() + "/scoutingFiles/");
                if(!dir.exists()){
                    dir.mkdir();
                }

                try{
                    File outFile = new File(dir, outStr);
                    FileOutputStream out = new FileOutputStream(outFile);
                    out.write(output.toString().getBytes());
                    out.close();
                } catch (IOException e) {
                    Log.e("Exception", "File write failed: " + e.toString());
                }

                Snackbar.make(findViewById(R.id.myConstraintLayout), "Successfully Saved: " + outStr, Snackbar.LENGTH_SHORT).show();

                scoutName.setText("");
                spinnerTeams.setSelection(0);
                newTeamNum.setText("");
                allianceSwitch.setChecked(false);
                matchNum.setText("");
                autoParking.setChecked(false);
                autoRepositioning.setChecked(false);
                endCapping.setChecked(false);
                endFoundation.setChecked(false);
                endParking.setChecked(false);
                numAutoPlaced.setText("0");
                numAutoSkystones.setText("0");
                numAutoStones.setText("0");
                numTeleDelivered.setText("0");
                numTelePlaced.setText("0");
                numTeleTallSky.setText("0");
                spinnerDT.setSelection(0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_files) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
