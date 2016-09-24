package lzw.learn_messagesbetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button login = (Button) findViewById(R.id.loginButton);
        final EditText nameInput = (EditText) findViewById(R.id.nameInput);
        final EditText passwordInput = (EditText) findViewById(R.id.passwordInput);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameInput.getText().toString().equals("abc")&&passwordInput.getText().toString().equals("123")){
                    Intent intent = new Intent(MainActivity.this,First.class);
                    intent.putExtra("name_get",nameInput.getText().toString());
                    intent.putExtra("password_get",passwordInput.getText().toString());
                    Toast.makeText(MainActivity.this,nameInput.getText().toString()+passwordInput.getText().toString(),Toast.LENGTH_SHORT).show();
                    startActivityForResult(intent,1);
                }
                else
                    Toast.makeText(MainActivity.this,"密码或账号错误",Toast.LENGTH_SHORT).show();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch(resultCode){
            case 1:
                if(resultCode==1){
                    Toast.makeText(MainActivity.this, "账号"+data.getStringExtra("name_return")+"密码"+data.getStringExtra("password_return"), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
