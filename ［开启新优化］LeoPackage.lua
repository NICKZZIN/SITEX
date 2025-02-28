dofile("LueWebView.lua")

--config visual, nomes, funções dos botões...
function LeoPackage ( tab_view )
    local viewTab = { }  -- Tabela para armazenar a configuração dos controles
    
    -- Iterando sobre a tabela de entrada
    for k , v in pairs ( tab_view ) do 
    -- Verificando o tipo de controle
        if v [ 2 ] == "Switch" then
   -- Adiciona o switch à tabela de visualização com as ações de ligar/desligar
            viewTab [ # viewTab + 1 ] = { 
            text = v [ 1 ], 
            isControl = v [ 2 ],
            open = v [ 3 ],  -- Função chamada quando o switch é ativado 
            close = v [ 4 ],  -- Função chamada quando o switch é desativado
            textColor = v [ 5 ] or nil }
             
          elseif v [ 2 ] == "Button" then
          -- Adiciona o botão à tabela de visualização com o evento de clique
            viewTab [ # viewTab + 1 ] = { 
            text = v [ 1 ], 
            isControl = v [ 2 ], 
            clickEvent = v [ 3 ], -- Função chamada quando o botão é clicado
            textColor = v [ 4 ] or nil } -- Cor do texto
        end
    end
    -- Tornar a interface invisível
    gg.setVisible ( true )
    
    -- Definir a interface com os controles configurados
    setUi ( viewTab )
end


-- Chamando a função LeoPackage para configurar a interface com controles
LeoPackage ( { 
{
        "退出事件" ,  -- Texto do botão
        "Button" ,     -- Tipo de controle
        function ( self )
            gg.toast ( "点击事件" )  -- Exibe uma mensagem ao clicar
            luajava.exit()
            os.exit()
        end

        ,
        "0xFFFFFFFF" ,  -- Cor do texto
    } , {
        "按钮事件" ,  -- Texto do switch
        "Switch" ,    -- Tipo de controle
        function ( self )
            gg.toast ( "开启" )  -- Mensagem quando ativado
        end

        ,
        function ( self )
            gg.toast ( "关闭" )  -- Mensagem quando desativado
        end

        ,
        "0xFF000000"  -- Cor do texto
    }, {
        "按钮事件" ,  -- Texto do switch
        "Switch" ,    -- Tipo de controle
        function ( self )
            gg.toast ( "开启" )  -- Mensagem quando ativado
        end

        ,
        function ( self )
            gg.toast ( "关闭" )  -- Mensagem quando desativado
        end

        ,
        "0xFF000000"  -- Cor do texto
    }, {
        "按钮事件" ,  -- Texto do switch
        "Switch" ,    -- Tipo de controle
        function ( self )
            gg.toast ( "开启" )  -- Mensagem quando ativado
        end

        ,
        function ( self )
            gg.toast ( "关闭" )   -- Mensagem quando desativado
        end

        ,
        "0xFF000000"  -- Cor do texto
    } } )


--[[
    LeoPackage({
        {
            "Texto do Controle",  -- Texto a ser exibido no controle
            "Tipo de Controle",   -- Tipo de controle ("Button" ou "Switch")
            Evento de Clique (se tipo for "Button"),  -- Função chamada ao clicar
            Cor do Texto,  -- Cor do texto (em hexadecimal)
        },
        {
            "Texto do Controle",  -- Texto a ser exibido no controle
            "Switch",  -- Tipo de Controle (se for switch)
            Função de Abertura,  -- Função quando ativado
            Função de Fechamento, -- Função quando desativado
            Cor do Texto,  -- Cor do texto (em hexadecimal)
        }
    })
]]