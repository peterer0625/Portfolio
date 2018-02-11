/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandpattern;

/**
 *
 * @author KT
 */
public class LightOnCommand implements Command
{
    private Light mLight = null;
    
    public LightOnCommand(Light light)
    {
        this.mLight = light;
    }
    
    @Override
    public void execute()
    {
        this.mLight.on();
    }
    
}
