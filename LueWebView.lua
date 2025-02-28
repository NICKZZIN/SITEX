--save
import "android.app.*"
import "android.os.*"
import "android.widget.*"
import "android.view.*"
import "android.content.*"
import "java.util.*"
import "java.lang.*"
import "android.*"
import "android.graphics.drawable.*"
import "android.graphics.PixelFormat"

import "android.view.animation.Animation"
import "android.view.animation.RotateAnimation"
import "android.animation.ObjectAnimator"
import "android.view.animation.DecelerateInterpolator"


context = activity
window = context.getSystemService ( "window" ) -- Obtém o gerenciador de janelas
local mObjectAnimator
local dObjectAnimator

function sparkle_animation ( view )
	-- Animação de brilho
	if ( mObjectAnimator == nil ) then
		mObjectAnimator = ObjectAnimator.ofFloat ( view , "alpha" , 0 , 1 )
		mObjectAnimator.setDuration ( 0 ) -- Duração da animação
		mObjectAnimator.setInterpolator ( DecelerateInterpolator ( ) ) -- Interpolador da animação, desaceleração
	end
end

function zoom_animation ( view )
	-- Animação de zoom
	if ( dObjectAnimator == nil ) then
		dObjectAnimator = ObjectAnimator.ofFloat ( view , "scaleX" , 0 , 1 )
		dObjectAnimator.setDuration ( 0 ) -- Duração da animação
		dObjectAnimator.setInterpolator ( DecelerateInterpolator ( ) ) -- Interpolador da animação, desaceleração
	end
end

function zoom_startanimation ( )
	dObjectAnimator.start ( )
end

function sparkle_startanimation ( )
	mObjectAnimator.start ( )
end

function getLayoutParams ( )
	local LayoutParams = WindowManager.LayoutParams
	local layoutParams = luajava.new ( LayoutParams )
	if ( Build.VERSION.SDK_INT >= 26 ) then
		-- Define o tipo de janela flutuante
		layoutParams.type = LayoutParams.TYPE_APPLICATION_OVERLAY
	else
		layoutParams.type = LayoutParams.TYPE_PHONE
	end

	layoutParams.format = PixelFormat.RGBA_8888 -- Define o fundo
	layoutParams.flags = LayoutParams.FLAG_NOT_FOCUSABLE -- Define o foco como finalizado
	layoutParams.gravity = Gravity.CENTER -- Define a gravidade
	layoutParams.width = LayoutParams.WRAP_CONTENT -- Largura do layout
	layoutParams.height = LayoutParams.WRAP_CONTENT -- Altura do layout
	return layoutParams
end

function getSideMenuParams()
    local LayoutParams = WindowManager.LayoutParams
    local layoutParams = luajava.new(LayoutParams)
    layoutParams.type = LayoutParams.TYPE_APPLICATION_OVERLAY
    layoutParams.format = PixelFormat.RGBA_8888
    layoutParams.flags = LayoutParams.FLAG_NOT_FOCUSABLE
    layoutParams.gravity = Gravity.CENTER
    layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT
    layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
    layoutParams.x = mainLayoutParams.x - 395 -- Ajuste para manter o menu ao lado esquerdo
    layoutParams.y = mainLayoutParams.y
    return layoutParams
end

function getShepeBackground ( color , radiu )
	-- Função para definir o fundo
	drawable = luajava.new ( GradientDrawable )
	drawable.setShape ( GradientDrawable.RECTANGLE )
	drawable.setColor ( color )
	drawable.setCornerRadii ( { radiu , radiu , radiu , radiu , radiu , radiu , radiu , radiu } )
	return drawable
end

sideMenu = {
    LinearLayout;
    layout_height = "fill";
    layout_width = "100dp";  -- Largura do menu lateral
    orientation = "vertical";
    background = getShepeBackground(0xCFF1F1F1, 20);
    {
        LinearLayout;
        layout_height = "278dp";
        layout_width = "135dp";
        
    };
};


xfc = {
	LinearLayout ;
	id = "touch" ;
	layout_height = "fill" ;
	orientation = "horizontal" ;
	layout_width = "fill" ;
	background = getShepeBackground ( 0xCFF1F1F1 , 20 ) ;
	{
        -- Menu Lateral, agora com largura fixa
        LinearLayout;
        layout_height = "fill";
        layout_width = "100dp";  -- Definindo a largura fixa para o menu lateral
        orientation = "vertical";
        background = getShepeBackground(0xCFF1F1F1, 20);
        id = "sideMenuView";
        {
            ImageView;  -- O ícone fixo no menu lateral
            id = "sideMenuIcon";
            layout_height = "73dp";  -- Tamanho do ícone
            layout_width = "73dp";
            src = "ic_menu.png";  -- O ícone que você quer mostrar no menu
            scaleType = "centerInside";  -- Ajuste a escala do ícone
            layout_marginTop = "20dp";  -- Ajuste a margem superior para posicionar o ícone
            layout_marginLeft = "13dp";  -- Ajuste a margem esquerda para posicionar o ícone
        };
        {
            ScrollView;
            layout_height = "match_parent";
            padding = "10dp";
            layout_width = "match_parent";
            VerticalScrollBarEnabled = false;
            {
                LinearLayout;
                layout_height = "match_parent";
                orientation = "vertical";
                id = "SideFuncLayout";
                layout_width = "match_parent";
            };
        };
    };
	{
		LinearLayout ;
		id = "ooo" ;
		layout_height = "300dp" ;
		orientation = "vertical" ;
		layout_width = "230dp" ;
		{
			LinearLayout ;
			layout_height = "25dp" ;
			layout_width = "match_parent" ;
			{
				LinearLayout ;
				layout_height = "match_parent" ;
				layout_width = "25dp" ;
			} ;
			{
				LinearLayout ;
				layout_height = "match_parent" ;
				layout_width = "match_parent" ;
				{
					TextView ;
					id = "title" ;
					layout_height = "match_parent" ;
					layout_width = "match_parent" ;
					text = "ELGG" ;
					textColor = "0xff000000" ;
					gravity = "center" ;
				} ;
			} ;
		} ;
		{
			ScrollView ;
			layout_height = "match_parent" ;
			padding = "10dp" ;
			layout_width = "match_parent" ;
			VerticalScrollBarEnabled = false ;
			{
				LinearLayout ;
				layout_height = "match_parent" ;
				orientation = "vertical" ;
				id = "FuncLayout" ;
				layout_width = "match_parent" ;
			} ;
		} ;
	} ;
    {
        ScrollView;
        layout_height = "match_parent";
        padding = "10dp";
        layout_width = "match_parent";
        VerticalScrollBarEnabled = false;
        {
            LinearLayout;
            layout_height = "match_parent";
            orientation = "vertical";
            id = "SideFuncLayout";
            layout_width = "match_parent";
        };
    };
 }; -- Janela flutuante


xfq = {
	LinearLayout ;
	layout_height = "fill" ;
	layout_width = "fill" ;
	{
		LinearLayout ;
		layout_width = "50dp" ;
		{
			ImageView ;
			layout_width = "50dp" ;
			src = "ic.png" ;
			id = "suspended_ball" ;
			layout_height = "50dp" ;
		} ;
	} ;
} ; -- Bola flutuante


mainLayoutParams = getLayoutParams ( )
xfq = loadlayout ( xfq )
xfc = loadlayout ( xfc )

sideMenuView = loadlayout(sideMenu)
sideMenuParams = getSideMenuParams()


function sideMenuIcon.onTouch(v, event)
    local Action = event.getAction()
    if Action == MotionEvent.ACTION_DOWN then
        isMove = false
        RawX = event.getRawX()
        RawY = event.getRawY()
        x = mainLayoutParams.x
        y = mainLayoutParams.y
        touchStartTime = os.clock()
    elseif Action == MotionEvent.ACTION_MOVE then
        isMove = true
        mainLayoutParams.x = tonumber(x) + (event.getRawX() - RawX)
        mainLayoutParams.y = tonumber(y) + (event.getRawY() - RawY)
        window.updateViewLayout(xfc, mainLayoutParams)
    elseif Action == MotionEvent.ACTION_UP then
        local touchDuration = os.clock() - touchStartTime
        if not isMove and touchDuration < 0.2 then
            -- Chama a função de minimizar ao clicar
            minimizeMenu()
        end
    end
    return true
end

function minimizeMenu()
    window.removeView(xfc) -- Remove o menu principal
    sparkle_animation(suspended_ball)
    sparkle_startanimation()
    window.addView(xfq, mainLayoutParams) -- Mostra a bola flutuante
end

function suspended_ball.onClick ( v )
	-- 悬浮球点击事件
	window.removeView ( xfq )
	zoom_animation ( ooo ) -- 动画事件添加动画给悬浮窗
	zoom_startanimation ( )
	window.addView ( xfc , mainLayoutParams )
end

function suspended_ball.onTouch ( v , event )
	-- Evento de movimento da bola flutuante
	local Action = event.getAction ( )
	if Action == MotionEvent.ACTION_DOWN then
		isMove = false
		-- Coordenadas XY ao clicar
		RawX = event.getRawX ( ) -- Obtém a coordenada X
		RawY = event.getRawY ( ) -- Obtém a coordenada Y
		x = mainLayoutParams.x -- Declara a variável x como a coordenada X original
		y = mainLayoutParams.y -- Declara a variável y como a coordenada Y original
	elseif Action == MotionEvent.ACTION_MOVE then
		isMove = true
		-- Coordenadas XY ao mover
		mainLayoutParams.x = tonumber ( x ) + ( event.getRawX ( ) - RawX )
		mainLayoutParams.y = tonumber ( y ) + ( event.getRawY ( ) - RawY )
		window.updateViewLayout ( xfq , mainLayoutParams )
	end
end

function touch.onTouch ( v , event )
	-- Evento de movimento da janela flutuante
	local Action = event.getAction ( )
	if Action == MotionEvent.ACTION_DOWN then
		isMove = false
		-- Coordenadas XY ao clicar
		RawX = event.getRawX ( ) -- Obtém a coordenada X
		RawY = event.getRawY ( ) -- Obtém a coordenada Y
		x = mainLayoutParams.x -- Declara a variável x como a coordenada X original
		y = mainLayoutParams.y -- Declara a variável y como a coordenada Y original
	elseif Action == MotionEvent.ACTION_MOVE then
		isMove = true
		-- Coordenadas XY ao mover
		mainLayoutParams.x = tonumber ( x ) + ( event.getRawX ( ) - RawX )
		mainLayoutParams.y = tonumber ( y ) + ( event.getRawY ( ) - RawY )
        
        window.updateViewLayout(xfc, mainLayoutParams)
	end
end

function setUi ( arr )
	--gg.setVisible ( false )
	function invoke ( )
		-- Prepara o Looper
		sparkle_animation ( suspended_ball ) -- Animação da bola flutuante
		sparkle_startanimation ( )
		if type ( arr ) ~= 'table' then
			return error ( '参数需是table类型' )
		end
		for i = 1 , # arr do
			local value = arr [ i ]
			if not value.text then
				value.text = string.format ( '功能%d' , i )
			end
			if not value.textColor then
				value.textColor = "0xFF000000"
			end
			local mButton = {
				Button ;
				text = value.text ;
				textColor = value.textColor ;
				padding = "5dp" ;
				layout_width = "match_parent" ;
				layout_height = "match_parent" ;
			} ;
			local switch = {
				Switch ;
				text = value.text ;
				textColor = value.textColor ;
				padding = "5dp" ;
				layout_width = "match_parent" ;
				layout_height = "match_parent" ;
			} ;
			local Controllibrary = {
				Switch = function ( )
					switch = loadlayout ( switch )
					switch.onClick = function ( )
						local mode = switch.checked and "open" or "close"
						local func = value [ mode ]
						runnable = {
							run = function ( )
								pcall ( func , value )
							end

							,
						}
						local newRun = luajava.createProxy ( "java.lang.Runnable" , runnable )
						local subThread = luajava.newInstance ( "java.lang.Thread" , newRun )
						subThread : start ( )
					end

					FuncLayout.addView ( switch )
				end

				;
				Button = function ( )
					mButton = loadlayout ( mButton )
					mButton.onClick = function ( )
						local mode = mButton.checked or "clickEvent"
						local func = value [ mode ]
						runnable = {
							run = function ( )
								pcall ( func , value )
							end

							,
						}
						local newRun = luajava.createProxy ( "java.lang.Runnable" , runnable )
						local subThread = luajava.newInstance ( "java.lang.Thread" , newRun )
						subThread : start ( )
					end

					FuncLayout.addView ( mButton )
				end
			}
            assert(Controllibrary [ value.isControl ] ,"输入了一个未知类型["..value.isControl.."]存在错误❌")
			Controllibrary [ value.isControl ] ( )
		end
		window.addView ( xfq , mainLayoutParams ) -- Adiciona o evento da janela
		Looper.loop ( )
	end
	-- Terceiro parâmetro para capturar todos os erros
	Lock.Ui(invoke,nil,function(err)
    print(err)
    luajava.exit()
end)
end
