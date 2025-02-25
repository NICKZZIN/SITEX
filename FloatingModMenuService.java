package bat.ggg.modmenu;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.IBinder;
import android.util.Base64;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FloatingModMenuService extends Service {
   
    public View mFloatingView;
    private Button close;
	private CheckBox botao1;
    private LinearLayout mButtonPanel;
    public RelativeLayout mCollapsed;
    public LinearLayout mExpanded;
    private RelativeLayout mRootContainer;
    public WindowManager mWindowManager;
    public WindowManager.LayoutParams params;
    private LinearLayout patches;
    private FrameLayout rootFrame;
    private ImageView startimage;
    private LinearLayout view1;
    private LinearLayout view2;
    private LinearLayout.LayoutParams hr;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return Service.START_NOT_STICKY;
    }
   @Override
    public void onCreate() {
        super.onCreate();
	   
	   
	   initFloating();
      
	//===========================//
	
	// encrypt your code 
	//your code save in sdcard 
	//generate simple code for(execute)
		//this project simple for execute scripts in sdcard using layout(modmenu
	   String file1 = "night_on.lua";
	    
	   String content1 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n" ;
	   escreverEmArquivo(file1, content1);
	   
	   String file2 = "night_off.lua";
	   String content2 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n";
	   escreverEmArquivo(file2, content2);
	   
	   String file3 = "damage_on.lua";
	   String content3 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n";
	   escreverEmArquivo(file3, content3);

	   String file4 = "damage_off.lua";
	   String content4 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n";
	   escreverEmArquivo(file4, content4);
	   
	   String file5 = "aimbot_on.lua";
	   String content5 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n";
	   escreverEmArquivo(file5, content5);
	   
	   String file6 = "aimbot_off.lua";
	   String content6 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n";
	   escreverEmArquivo(file6, content6);
	   
	   String filespeed0 = "speed0.lua";
	   String speed0 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n";
	   escreverEmArquivo(filespeed0, speed0);
	   	   
	   String filespeed1 = "speed1.lua";
	   String speed1 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n";
	   escreverEmArquivo(filespeed1, speed1);
	   
	   String filespeed2 = "speed2.lua";
	   String speed2 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n";
	   escreverEmArquivo(filespeed2, speed2);
	   
	   String filespeed3= "speed3.lua";
	   String speed3 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n";
	   escreverEmArquivo(filespeed3, speed3);

	   String filespeed4= "speed4.lua";
	   String speed4 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n";
	   escreverEmArquivo(filespeed4, speed4);

	   String filespeed5= "speed5.lua";
	   String speed5 = "gg.setVisible(true)\n" +
		   "--gg.ssetProcess(\"com.ghisler.android.TotalCommander\")\n" + // set here process game
		   "gg.setRanges(gg.REGION_ANONYMOUS)\n" +
		   "gg.searchNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.refineNumber(\"1\", gg.TYPE_FLOAT)\n" +
		   "gg.getResults(100)\n" +
		   "gg.editAll(\"-1\", gg.TYPE_FLOAT)\n" +
		   "gg.clearResults()\n" +
		   "gg.setVisible(false)\n";
	   escreverEmArquivo(filespeed5, speed5);
	   
	}
	public static void escreverEmArquivo2(Context context, String nomeArquivo, String conteudo) {
        FileOutputStream fos = null;
        try {
            // Abre o arquivo no diretório interno do aplicativo
            fos = context.openFileOutput(nomeArquivo, Context.MODE_PRIVATE);

            // Escreve o conteúdo no arquivo
            String conteudoFormatado = conteudo;
            fos.write(conteudoFormatado.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	
	
		public static void escreverEmArquivo(String nomeArquivo, String conteudo) {
		File diretorioExterno = new File("/sdcard/"); 
			File arquivo = new File(diretorioExterno, nomeArquivo);

			FileWriter fileWriter = null;
			try {
					fileWriter = new FileWriter(arquivo); 
				fileWriter.write(conteudo); 
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fileWriter != null) {
					try {
						fileWriter.close(); 
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		
	}
	
    public void initFloating() {
        this.rootFrame = new FrameLayout(this);
        this.mRootContainer = new RelativeLayout(this);
        this.mCollapsed = new RelativeLayout(this);
        this.mExpanded = new LinearLayout(this);
        this.view1 = new LinearLayout(this);
        this.patches = new LinearLayout(this);
        this.view2 = new LinearLayout(this);
        this.mButtonPanel = new LinearLayout(this);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-20, -1));
        relativeLayout.setPadding(10, 10, 10, 10);
        relativeLayout.setVerticalGravity(16);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(300, -20);
        layoutParams.addRule(11);

		close = new Button(this);
        close.setText("Hide");
        close.setTextColor(Color.parseColor("#FF000000"));
        close.setLayoutParams(layoutParams);
		android.graphics.drawable.GradientDrawable GIGABGI = new android.graphics.drawable.GradientDrawable();
		GIGABGI.setColor(Color.parseColor("#ffffff"));;
		GIGABGI.setStroke(3, Color.parseColor("#000000"));
		close.setBackground(GIGABGI);
		
		relativeLayout.addView(this.close);
       
        rootFrame.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        mRootContainer.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        mCollapsed.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        mCollapsed.setVisibility(View.VISIBLE);
        startimage = new ImageView(getBaseContext());
        startimage.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        int applyDimension = (int) TypedValue.applyDimension(1, (float) 70, getResources().getDisplayMetrics());
        startimage.getLayoutParams().height = applyDimension;
        startimage.getLayoutParams().width = applyDimension;
        startimage.requestLayout();
        startimage.setScaleType(ImageView.ScaleType.FIT_XY);
        
		// icon mod base 64
		byte[] decode = Base64.decode("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", 0);
        startimage.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        ((ViewGroup.MarginLayoutParams) startimage.getLayoutParams()).topMargin = convertDipToPixels(10);
		
        this.mExpanded.setVisibility(8);
        this.mExpanded.setBackgroundColor(Color.parseColor("#00B0FF"));
        this.mExpanded.setGravity(17);
        this.mExpanded.setOrientation(1);
        this.mExpanded.setPadding(5, 0, 5, 0);
        this.mExpanded.setLayoutParams(new LinearLayout.LayoutParams(dp(260), -2));
        this.mExpanded.getBackground().setAlpha(250);
        android.graphics.drawable.GradientDrawable DFIABBI = new android.graphics.drawable.GradientDrawable();
        DFIABBI.setColor(Color.parseColor("#00000000"));
        DFIABBI.setCornerRadius(10);
        DFIABBI.setStroke(5, Color.parseColor("#FF00B0FF"));
        this.mExpanded.setBackgroundColor(Color.parseColor("#ff000000"));

        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, dp(190)));
        scrollView.setBackgroundColor(Color.parseColor("WHITE"));
        scrollView.getBackground().setAlpha(250);

        this.patches.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.patches.setOrientation(1);

        this.hr = new LinearLayout.LayoutParams(-1, -1);
        this.hr.setMargins(0, 0, 0, 5);
        this.mButtonPanel.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));

        TextView textView = new TextView(this);
        textView.setTextSize(50);
        textView.setText("By Batman Games");
        textView.setTextColor(Color.WHITE);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(20.0f);
        textView.setPadding(10, 25, 10, 5);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);

        TextView textView2 = new TextView(this);
        textView2.setTextSize(50);
        textView2.setText("@batmangamesS");
        textView2.setTextColor(Color.WHITE);
        textView2.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
        textView2.setTextSize(10.0f);
        textView2.setPadding(10, 5, 10, 10);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        textView2.setLayoutParams(layoutParams3);

        new LinearLayout.LayoutParams(-1, dp(25)).topMargin = dp(2);
        rootFrame.addView(mRootContainer);
        mRootContainer.addView(mCollapsed);
        mRootContainer.addView(mExpanded);
        mCollapsed.addView(startimage);
        mExpanded.addView(textView);
        mExpanded.addView(textView2);
        mExpanded.addView(view1);
        mExpanded.addView(scrollView);
        scrollView.addView(patches);
        mExpanded.addView(view2);
        mExpanded.addView(relativeLayout);
        mFloatingView = rootFrame;
		
        if (Build.VERSION.SDK_INT >= 26) {
            params = new WindowManager.LayoutParams(-2, -2, 2038, 8, -3);
        } else {
            params = new WindowManager.LayoutParams(-2, -2, 2002, 8, -3);
        }
        WindowManager.LayoutParams layoutParams4 = params;
        layoutParams4.gravity = 51;
        layoutParams4.x = 0;
        layoutParams4.y = 100;
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);
        RelativeLayout relativeLayout2 = mCollapsed;
        LinearLayout linearLayout = mExpanded;
        mFloatingView.setOnTouchListener(onTouchListener());
        startimage.setOnTouchListener(onTouchListener());

        initMenuButton(relativeLayout2, linearLayout);
        
    }

    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {
            final View collapsedView = mCollapsed;
            final View expandedView = mExpanded;
            private float initialTouchX;
            private float initialTouchY;
            private int initialX;
            private int initialY;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = motionEvent.getRawX();
                        initialTouchY = motionEvent.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int rawX = (int) (motionEvent.getRawX() - initialTouchX);
                        int rawY = (int) (motionEvent.getRawY() - initialTouchY);
                        if (rawX < 10 && rawY < 10 && isViewCollapsed()) {
                             collapsedView.setVisibility(View.GONE);
                            expandedView.setVisibility(View.VISIBLE);
                         
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                         params.x = initialX + ((int) (motionEvent.getRawX() - initialTouchX));
                        params.y = initialY + ((int) (motionEvent.getRawY() - initialTouchY));
                        mWindowManager.updateViewLayout(mFloatingView, params);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private void initMenuButton(final View view2, final View view3) {
        startimage.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    view2.setVisibility(View.GONE);
                    view3.setVisibility(View.VISIBLE);
 
                }
            });
			
		close.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					view2.setVisibility(View.VISIBLE);
					view2.setAlpha(0.95f);
					view3.setVisibility(View.GONE);
					
				}
			});
			
			
		addTextClock("", new InterfaceBtn() {
				@Override
				public void OnWrite() {
					
					}
			});
		night("mode night", new InterfaceBtn() {
				@Override
				public void OnWrite() {
					
					}
			});
			
		damage("Damage hack", new InterfaceBtn() {
				@Override
				public void OnWrite() {
					
					}
			});

		aimbot("aimbot", new InterfaceBtn() {
		@Override
				public void OnWrite() {
					
					
				}
					
				});
			
		addSeekBar("SpeedHack", 0, 5, new InterfaceInt() {
				@Override
				public void OnWrite(int value) {
					switch (value) {
						case 0:
							toastC4F(getApplicationContext(), "value 0", Color.RED, 20, Color.WHITE, 20, 3);
								break;
						case 1:
							toastC4F(getApplicationContext(), "value 1", Color.RED, 20, Color.WHITE, 20, 3);
							break;
						case 2:
							toastC4F(getApplicationContext(), "value 2", Color.RED, 20, Color.WHITE, 20, 3);
							break;
						case 3:
							toastC4F(getApplicationContext(), "value 3", Color.RED, 20, Color.WHITE, 20, 3);
							break;
						case 4:
							toastC4F(getApplicationContext(), "value 4", Color.RED, 20, Color.WHITE, 20, 3);
							break;
						case 5:
							toastC4F(getApplicationContext(), "value 5", Color.RED, 20, Color.WHITE, 20, 3);
							break;
						
					}
				}
			});
	
	exit("Exit", new InterfaceBtn() {
	@Override
	public void OnWrite() {
		view3.setVisibility(View.GONE);
		//onDestroy();
        //System.exit(0);
	}

	});
	
  }
    
	public void night(String feature, final InterfaceBtn interfaceBtn) {
		final CheckBox checkBox = new CheckBox(this);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
		);
		layoutParams.setMargins(7, 5, 7, 5);
		checkBox.setLayoutParams(layoutParams);
		checkBox.setTextSize(13.0f);
		checkBox.setTextColor(Color.parseColor("BLACK"));
		checkBox.setText(feature); // Define o texto do CheckBox
	checkBox.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					interfaceBtn.OnWrite();
					if (checkBox.isChecked()) {
						toastC4F(getApplicationContext(), "wait activating fuction 1", Color.RED, 20, Color.WHITE, 20, 3);
						
						} else {
							toastC4F(getApplicationContext(), "wait deactivating", Color.RED, 20, Color.WHITE, 20, 3);
						}
				}
			});
patches.addView(checkBox);
	}
			
	public void damage(String feature, final InterfaceBtn interfaceBtn) {
		final CheckBox checkBox = new CheckBox(this);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
		);
		layoutParams.setMargins(7, 5, 7, 5);
		checkBox.setLayoutParams(layoutParams);
		checkBox.setTextSize(13.0f);
		checkBox.setTextColor(Color.parseColor("BLACK"));
		checkBox.setText(feature); // Define o texto do CheckBox
		checkBox.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					interfaceBtn.OnWrite();
					if (checkBox.isChecked()) {
						toastC4F(getApplicationContext(), "wait activating function 2", Color.RED, 20, Color.WHITE, 20, 3);

					} else {
						toastC4F(getApplicationContext(), "wait deactivating", Color.RED, 20, Color.WHITE, 20, 3);
					}
				}
			});
		patches.addView(checkBox);
	}
	
	public void aimbot(String feature, final InterfaceBtn interfaceBtn) {
		final CheckBox checkBox = new CheckBox(this);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
		);
		layoutParams.setMargins(7, 5, 7, 5);
		checkBox.setLayoutParams(layoutParams);
		checkBox.setTextSize(13.0f);
		checkBox.setTextColor(Color.parseColor("BLACK"));
		checkBox.setText(feature); // Define o texto do CheckBox
		checkBox.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					interfaceBtn.OnWrite();
					if (checkBox.isChecked()) {
						toastC4F(getApplicationContext(), "wait activating function 3", Color.RED, 20, Color.WHITE, 20, 3);

					} else {
						toastC4F(getApplicationContext(), "wait deactivating", Color.RED, 20, Color.WHITE, 20, 3);
					}
				}
			});
		patches.addView(checkBox);
	}
	
	

	public void exit(String feature, final InterfaceBtn interfaceBtn) {
		final RadioButton radioButton = new RadioButton(this);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
		);
		layoutParams.setMargins(7, 5, 7, 5);
		radioButton.setLayoutParams(layoutParams);
		radioButton.setTextSize(13.0f);
		radioButton.setTextColor(Color.parseColor("BLACK"));
		radioButton.setText(feature); 
        radioButton.setOnClickListener(new View.OnClickListener() {
				private boolean isSelected = false;

				@Override
				public void onClick(View v) {
					interfaceBtn.OnWrite();
					if (isSelected) {
						radioButton.setChecked(false);
						
						isSelected = false;
					} else {
						radioButton.setChecked(true);
						toastC4F(getApplicationContext(), "exiting...", Color.RED, 20, Color.WHITE, 20, 3);
						
						isSelected = true;
					}
				}
			});
patches.addView(radioButton);
	}
	
	public void addTextClock(String feature, final InterfaceBtn interfaceBtn) {
		final TextClock textClock = new TextClock(this);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
			LinearLayout.LayoutParams.WRAP_CONTENT
			);
		layoutParams.setMargins(150, 5, 150, 5);
		textClock.setLayoutParams(layoutParams);
		textClock.setFormat12Hour("hh:mm:ss a"); // Formato para 12 horas
		textClock.setFormat24Hour("HH:mm:ss");  // Formato para 24 horas
		textClock.setTextColor(Color.WHITE);
		textClock.setTextSize(20);
		textClock.setBackgroundColor(Color.BLACK);
        textClock.setOnClickListener(new View.OnClickListener() {
        @Override
				public void onClick(View v) {
				interfaceBtn.OnWrite();
					}
				});
patches.addView(textClock);
		}
		
	private void addSeekBar(String str, int progress, int max, InterfaceInt sb) {
		final LinearLayout linearLayout = new LinearLayout(this);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
		linearLayout.setPadding(20, 20, 20, 20);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.setGravity(Gravity.CENTER_VERTICAL);
		linearLayout.setLayoutParams(layoutParams);
		linearLayout.setBackgroundColor(Color.WHITE);
		final TextView textView = new TextView(this);
		textView.setText(str + ": " + progress);
		textView.setTextSize(16);
		textView.setTextColor(Color.BLACK);
		SeekBar seekBar = new SeekBar(this);
		seekBar.setScaleY(0.5f);  // Diminui a altura do SeekBar
		LinearLayout.LayoutParams seekBarParams = new LinearLayout.LayoutParams(
            0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
		seekBarParams.setMargins(20, 0, 0, 0);
		seekBar.setLayoutParams(seekBarParams);
		seekBar.setMax(max);
		seekBar.setProgress(progress);
		GradientDrawable progressDrawable = new GradientDrawable();
		progressDrawable.setColor(Color.GRAY);  // Cor da barra
		progressDrawable.setCornerRadius(5);  // Arredondamento leve
		progressDrawable.setSize(0, 8);  // Altura bem fina

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
			seekBar.setProgressDrawableTiled(progressDrawable);
		} else {
			seekBar.setProgressDrawable(progressDrawable);
		}
		GradientDrawable thumbDrawable = new GradientDrawable();
		thumbDrawable.setColor(Color.DKGRAY);  // Cor do thumb
		thumbDrawable.setSize(30, 30);  // Thumb pequeno
		thumbDrawable.setShape(GradientDrawable.OVAL);
		seekBar.setThumb(thumbDrawable);
		final String str3 = str;
		final InterfaceInt sb3 = sb;
		final int initialProgress = progress;
		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					linearLayout.setBackgroundColor(Color.LTGRAY);
				}
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					linearLayout.setBackgroundColor(Color.WHITE);
				}
				@Override
				public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
					if (i < initialProgress) {
						seekBar.setProgress(initialProgress);
						sb3.OnWrite(initialProgress);
						textView.setText(str3 + ": " + initialProgress);
					} else {
						sb3.OnWrite(i);
						textView.setText(str3 + ": " + i);
					}
				}
			});

		linearLayout.addView(textView);
		linearLayout.addView(seekBar);
		this.patches.addView(linearLayout);
	}
    boolean delayed;

    public boolean isViewCollapsed() {
        return mFloatingView == null || mCollapsed.getVisibility() == View.VISIBLE;
    }

    private int convertDipToPixels(int i) {
        return (int) ((((float) i) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int dp(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public void onDestroy() {
        super.onDestroy();
        View view = mFloatingView;
        if (view != null) {
            mWindowManager.removeView(view);
        }
    }
 
    private interface InterfaceBtn {
        void OnWrite();
    }

    private interface InterfaceInt {
        void OnWrite(int i);
    }
	
	public static void toastC4F(Context c, String msg, int textColor, int textSize, int bgColor, int cornerRadius, int position) {
		Toast c4f = Toast.makeText(c, msg, Toast.LENGTH_LONG);
		View vw = c4f.getView();
		TextView textView = vw.findViewById(android.R.id.message);
		textView.setTextSize(textSize);
		textView.setTextColor(textColor);
		textView.setGravity(Gravity.CENTER);
		GradientDrawable gD = new GradientDrawable();
		gD.setColor(bgColor);
		gD.setCornerRadius(cornerRadius);
		vw.setBackgroundDrawable(gD);
		vw.setPadding(15, 10, 15, 10);
		vw.setElevation(10);

		switch (position) {
			case 1:
				c4f.setGravity(Gravity.TOP, 0, 150);
				break;

			case 2:
				c4f.setGravity(Gravity.CENTER, 0, 0);
				break;

			case 3:
				c4f.setGravity(Gravity.BOTTOM, 0, 150);
				break;
		}
		c4f.show();
	}
	
}
