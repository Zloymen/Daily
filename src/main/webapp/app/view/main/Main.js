/**
 * This class is the main view for the application. It is specified in app.js as the
 * "autoCreateViewport" property. That setting automatically applies the "viewport"
 * plugin to promote that instance of this class to the body element.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */

Ext.define('ExtJS5Diary.view.main.Main', {
    extend: 'Ext.container.Container',

    requires: [
        'ExtJS5Diary.view.main.MainController',
        'ExtJS5Diary.view.main.MainModel'
    ],

    xtype: 'app-main',

    controller: 'main',
    plugins: 'viewport',
    viewModel: {
        type: 'main'
    },

    layout: {
        type: 'border'
    },

    items: [{
        region: 'west',
        xtype: 'grid',
        reference: 'projects',
        title: 'Projects',
        width: 250,
        split: true,
        collapsible: true,
        selModel: {
            /*listeners: {
                selectionchange: ''
            }*/
        },
        bind: {
            //store: '',
            // Bind the project for the current user as the default selection (single).
            selection: {
                //bindTo: '',
                single: true
            }
        },
        columns: [{
            text: 'Name',
            dataIndex: 'name',
            flex: 1
        }, {
            xtype: 'actioncolumn',
            width: 20,
            //handler: '',
            stopSelection: false,
            items: [{
                tooltip: 'Search tickets',
                iconCls: 'search'
            }]
        }]
        },{
            xtype: 'tabpanel',
            region: 'center',
            flex: 1,
            reference: 'main',
            items: [{
                xtype: 'app-dashboard',
                title: 'Dashboard',
                listeners: {
                    //viewticket: '',
                    //edituser: ''
                }
            }]
        }]});
