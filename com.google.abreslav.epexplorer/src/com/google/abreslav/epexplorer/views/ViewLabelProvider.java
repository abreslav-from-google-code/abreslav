/**
 * 
 */
package com.google.abreslav.epexplorer.views;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.pde.internal.runtime.PDERuntimePluginImages;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

import com.google.abreslav.epexplorer.model.AttributeNode;
import com.google.abreslav.epexplorer.model.ConfigurationElementNode;
import com.google.abreslav.epexplorer.model.ContributorNode;
import com.google.abreslav.epexplorer.model.ExtensionNode;
import com.google.abreslav.epexplorer.model.ExtensionPointNode;
import com.google.abreslav.epexplorer.model.ITreeNode;
import com.google.abreslav.epexplorer.model.ITreeNodeVisitor;
import com.google.abreslav.epexplorer.model.NamespaceNode;

class ViewLabelProvider extends LabelProvider {

	private final Image fPluginImage;

	private final Image fLibraryImage;

	private final Image fRuntimeImage;

	private final Image fGenericTagImage;

	private final Image fGenericAttrImage;

	private final Image fExtensionImage;

	private final Image fExtensionsImage;

	private final Image fExtensionPointImage;

	private final Image fExtensionPointsImage;

	private final Image fRequiresImage;

	private final Image fReqPluginImage;

	private final Image fLocationImage;
	
	// IConfigurationElement => Image
	private final Map imageCache = new HashMap();;
	
	private ITreeNodeVisitor imageSwitch = new ITreeNodeVisitor() {

		public Object visit(AttributeNode node) {
			return fGenericAttrImage;
		}

		public Object visit(ConfigurationElementNode node) {
			Image specialIcon = getIconFor(node);
			if (specialIcon != null) {
				return specialIcon;
			}
			return fGenericTagImage;
		}

		public Object visit(ExtensionNode node) {
			return fExtensionImage;
		}

		public Object visit(ExtensionPointNode node) {
			return fExtensionPointImage;
		}

		public Object visit(NamespaceNode node) {
			return fPluginImage;
		}

		public Object visit(ContributorNode node) {
			return fExtensionsImage;
		}
		
	};

	ViewLabelProvider() {
		fPluginImage = PDERuntimePluginImages.DESC_PLUGIN_OBJ.createImage();
		fReqPluginImage = PDERuntimePluginImages.DESC_REQ_PLUGIN_OBJ
				.createImage();
		fExtensionPointImage = PDERuntimePluginImages.DESC_EXT_POINT_OBJ
				.createImage();
		fExtensionPointsImage = PDERuntimePluginImages.DESC_EXT_POINTS_OBJ
				.createImage();
		fExtensionImage = PDERuntimePluginImages.DESC_EXTENSION_OBJ
				.createImage();
		fExtensionsImage = PDERuntimePluginImages.DESC_EXTENSIONS_OBJ
				.createImage();
		fRequiresImage = PDERuntimePluginImages.DESC_REQ_PLUGINS_OBJ
				.createImage();
		fLibraryImage = PDERuntimePluginImages.DESC_JAVA_LIB_OBJ.createImage();
		fGenericTagImage = PDERuntimePluginImages.DESC_GENERIC_XML_OBJ
				.createImage();
		fGenericAttrImage = PDERuntimePluginImages.DESC_ATTR_XML_OBJ
				.createImage();
		fRuntimeImage = PDERuntimePluginImages.DESC_RUNTIME_OBJ.createImage();
		fLocationImage = PDERuntimePluginImages.DESC_LOCATION.createImage();

	}

	public void dispose() {
		fPluginImage.dispose();
		fReqPluginImage.dispose();
		fExtensionPointImage.dispose();
		fExtensionPointsImage.dispose();
		fExtensionImage.dispose();
		fExtensionsImage.dispose();
		fRequiresImage.dispose();
		fLibraryImage.dispose();
		fGenericTagImage.dispose();
		fGenericAttrImage.dispose();
		fRuntimeImage.dispose();
		fLocationImage.dispose();
		for (Iterator i = imageCache.values().iterator(); i.hasNext();) {
			Image img = (Image) i.next();
			img.dispose();
		}
	}

	private Image getIconFor(ConfigurationElementNode node) {
		Image result = (Image) imageCache.get(node);
		if (result == null) {
			String icon = node.getConfigurationElement().getAttribute("icon");
			if (icon != null && !"none".equals(icon)) {
				String path = icon.startsWith("$nl$") ? icon : "$nl$/" + icon; //$NON-NLS-1$
				String contributor = node.getConfigurationElement().getContributor().getName();
				Bundle bundle = Platform.getBundle(contributor);
				URL url = FileLocator.find(bundle, new Path(path), null);
				result = ImageDescriptor.createFromURL(url).createImage();
				imageCache.put(node, result);
			}
		}
		return result;
	}

	public String getText(Object obj) {
		return obj.toString();
	}

	public Image getImage(Object obj) {
		if (obj instanceof ITreeNode) {
			ITreeNode node = (ITreeNode) obj;
			return (Image) node.accept(imageSwitch);
		}
		return null;
	}
	
	public ImageDescriptor getNamespaceImageDescriptor() {
		return PDERuntimePluginImages.DESC_PLUGIN_OBJ;
	}
	
	public ImageDescriptor getExtensionPointImageDescriptor() {
		return PDERuntimePluginImages.DESC_EXT_POINT_OBJ;
	}
	
	public ImageDescriptor getContributorImageDescriptor() {
		return PDERuntimePluginImages.DESC_EXTENSIONS_OBJ;
	}
}