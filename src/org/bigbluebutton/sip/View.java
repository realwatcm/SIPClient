package org.bigbluebutton.sip;

import org.bigbluebutton.sip.account.AccountInfo;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.pjsip.pjsua.Callback;
import org.pjsip.pjsua.SWIGTYPE_p_pjsip_rx_data;
import org.pjsip.pjsua.pjsip_cred_data_type;
import org.pjsip.pjsua.pjsip_cred_info;
import org.pjsip.pjsua.pjsip_transport_type_e;
import org.pjsip.pjsua.pjsua;
import org.pjsip.pjsua.pjsuaConstants;
import org.pjsip.pjsua.pjsua_acc_config;
import org.pjsip.pjsua.pjsua_call_info;
import org.pjsip.pjsua.pjsua_call_media_status;
import org.pjsip.pjsua.pjsua_config;
import org.pjsip.pjsua.pjsua_logging_config;
import org.pjsip.pjsua.pjsua_transport_config;

public class View extends ViewPart {
	public static final String ID = "org.bigbluebutton.sip.view";

	private FormToolkit toolKit ;
	private ScrolledForm sc_form ;
	private AccountInfo acc = null;
	
	private static boolean connected = false ;
	private static String errMsg = null ;

	static class PjsuaCallback extends Callback {
		@Override
		public void on_incoming_call(int acc_id, int call_id, SWIGTYPE_p_pjsip_rx_data rdata) {
			// TODO Auto-generated method stub
			super.on_incoming_call(acc_id, call_id, rdata);
		}
		
		/* Callback called by the library when call's media state has changed */
		@Override
		public void on_call_media_state(int call_id)
		{
		    pjsua_call_info info = new pjsua_call_info();

		    pjsua.call_get_info(call_id, info);

		    if (info.getMedia_status() == pjsua_call_media_status.PJSUA_CALL_MEDIA_ACTIVE) {
		        // When media is active, connect call to sound device.
		    	pjsua.conf_connect(info.getConf_slot(), 0);
		    	pjsua.conf_connect(0, info.getConf_slot());
		    }
		}
	}
	
	protected static void error_exit(String message, int status) {
		System.out.println("Exit with status code: " + status + " and message: " + message);		
		pjsua.destroy() ;
		System.exit(status);
	}
	/**
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
	 */
	/*class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			if (parent instanceof Object[]) {
				return (Object[]) parent;
			}
	        return new Object[0];
		}
	}*/

	/*class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}

		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_ELEMENT);
		}
	}*/

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		
		  if ( null == acc ){
			  acc = new AccountInfo();
		  }
		  
		  toolKit = new FormToolkit(parent.getDisplay());
		  sc_form = toolKit.createScrolledForm(parent);
		  
		  
		  TableWrapLayout layout = new TableWrapLayout();
		  TableWrapData td = new TableWrapData();
		  
		  layout.numColumns = 2;
		  GridData gd = new GridData();
		  gd.horizontalSpan = 2;
		  
		  //Label l_error = new Label(sc_form.getBody(),SWT.NULL);

		  Label l_domain = new Label(sc_form.getBody(), SWT.NULL);
		  l_domain.setText("Domain :");
		  final Text t_domain = new Text(sc_form.getBody(), SWT.BORDER);	  
		  t_domain.setLayoutData(new TableWrapData(TableWrapData.LEFT));
		  
		  Label l_room = new Label(sc_form.getBody(), SWT.NULL);
		  l_room.setText("Room :");
		  final Text t_room = new Text(sc_form.getBody(), SWT.BORDER);	  
		  t_room.setLayoutData(new TableWrapData(TableWrapData.LEFT));
		  
		  Label l_name = new Label(sc_form.getBody(), SWT.NULL);
		  l_name.setText("Name :");
		  final Text t_name = new Text(sc_form.getBody(), SWT.BORDER);	  
		  t_name.setLayoutData(new TableWrapData(TableWrapData.LEFT));
		  
		  
		  final Button button = new Button(sc_form.getBody(), SWT.BUTTON1);
		  button.setText("   connect   ");
		  button.addMouseListener(new MouseListener(){

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDown(MouseEvent e) {
				// TODO Auto-generated method stub
				connected = ! connected ;
				if ( true == connected ){
					
					button.setText("disconnect");
					connectToSip(t_domain.getText(),t_room.getText(),t_name.getText());
					
					
				}else{
					
					pjsua.destroy() ;
					button.setText("connect");
					
					
				}
			}

			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  
		  td = new TableWrapData();
		  td.colspan = 2;
		  td.align = TableWrapData.CENTER ;
		  button.setLayoutData(td);
		  sc_form.getBody().setLayout(layout);
		  sc_form.setText("BigBlueButton SIP Phone");

	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		sc_form.setFocus();
	}
	
	/**
	  * Disposes the toolkit
	  */
	 public void dispose() {
	  toolKit.dispose();
	  pjsua.destroy() ;
	  super.dispose();
	 }
	 
	 public void connectToSip(String domain, String room, String name){
		int[] acc_id = new int[1];
		int status;
		
		status = pjsua.create();
	    if (status != pjsuaConstants.PJ_SUCCESS) {
	    	error_exit("Error in pjsua_create()", status);
	    }
	    
	    acc.setDomain(domain);
	    acc.setRoom(room);
	    acc.setDisplayName(name);
	    
	    status = pjsua.verify_sip_url(acc.getSipCallToUrl());
        if (status != pjsuaConstants.PJ_SUCCESS){
        	errMsg =  "Invalid URL in argv" ;
        	error_exit("Invalid URL in argv", status);
        }
		
        /** pjsua initialization **/
        {
        	pjsua_config cfg = new pjsua_config();
        	pjsua_logging_config log_cfg = new pjsua_logging_config();
        	pjsua.config_default(cfg);
        
        	cfg.setCb(pjsuaConstants.WRAPPER_CALLBACK_STRUCT);
        	pjsua.setCallbackObject(new PjsuaCallback());

        	pjsua.logging_config_default(log_cfg);
        	log_cfg.setConsole_level(4);
        
        	status = pjsua.init(cfg, log_cfg, null);
        	if (status != pjsuaConstants.PJ_SUCCESS){
        		errMsg =  "Error in pjsua_init()" ;
        		error_exit("Error in pjsua_init()", status);
        	}
        }
        
        {
        	pjsua_transport_config cfg = new pjsua_transport_config();

	        pjsua.transport_config_default(cfg);
	        cfg.setPort(acc.getPort());
	        status = pjsua.transport_create(pjsip_transport_type_e.PJSIP_TRANSPORT_UDP, cfg, null);
	        if (status != pjsuaConstants.PJ_SUCCESS){
	        	errMsg =  "Error creating transport" ;
	        	error_exit("Error creating transport", status);
	        }
        }
        
        status = pjsua.start();
	    if (status != pjsuaConstants.PJ_SUCCESS){
	    	errMsg =  "Error starting pjsua" ;
	    	error_exit("Error starting pjsua", status);
	    }
        
	    /* Register to SIP server by creating SIP account. */
	    {
	    	pjsua_acc_config cfg = new pjsua_acc_config();

	        pjsua.acc_config_default(cfg);
	        cfg.setId(pjsua.pj_str_copy("\"" + acc.getDisplayName() + "\"" + " " + acc.getProtocol() + acc.getUserName() + "@" + acc.getDomain()));
	        cfg.setReg_uri(pjsua.pj_str_copy(acc.getProtocol() + acc.getDomain()));
	        cfg.setCred_count(1);
	        pjsip_cred_info cred_info = cfg.getCred_info();
	        cred_info.setRealm(pjsua.pj_str_copy(acc.getRealm()));
	        cred_info.setScheme(pjsua.pj_str_copy(acc.getAuth()));
	        cred_info.setUsername(pjsua.pj_str_copy(acc.getUserName()));
	        cred_info.setData_type(pjsip_cred_data_type.PJSIP_CRED_DATA_PLAIN_PASSWD.swigValue());
	        cred_info.setData(pjsua.pj_str_copy(acc.getPassword()));

	        status = pjsua.acc_add(cfg, pjsuaConstants.PJ_TRUE, acc_id);
	        if (status != pjsuaConstants.PJ_SUCCESS){
	        	errMsg =  "Error adding account" ;
	        	error_exit("Error adding account", status);
	        }
	    }
	    
	    /* If URL is specified, make call to the URL. */
	    if(true) {
	    	int[] call_id = new int[1];
	        status = pjsua.call_make_call(acc_id[0], pjsua.pj_str_copy(acc.getSipCallToUrl()), 0, null, null, call_id);
	        if (status != pjsuaConstants.PJ_SUCCESS){
	        	errMsg =  "Error making call" ;
	        	error_exit("Error making call", status);
	        }
	    }
	 }

}